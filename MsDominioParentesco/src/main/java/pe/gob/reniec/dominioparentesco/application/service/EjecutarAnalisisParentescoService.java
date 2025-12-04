package pe.gob.reniec.dominioparentesco.application.service;

import pe.gob.reniec.dominioparentesco.domain.model.*;
import pe.gob.reniec.dominioparentesco.domain.ports.in.EjecutarAnalisisParentescoUseCase;
import pe.gob.reniec.dominioparentesco.domain.ports.out.AnalisisParentescoDataPort;
import pe.gob.reniec.dominioparentesco.domain.ports.out.APDDataPort;
import pe.gob.reniec.dominioparentesco.domain.ports.out.ActasDataPort;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Servicio de aplicación que implementa el caso de uso de ejecutar análisis de parentesco.
 * Orquesta el flujo completo del análisis utilizando el modelo rico de dominio.
 * 
 * NO utiliza frameworks - es Java puro.
 */
public class EjecutarAnalisisParentescoService implements EjecutarAnalisisParentescoUseCase {
    
    private final AnalisisParentescoDataPort analisisParentescoDataPort;
    private final APDDataPort apdDataPort;
    private final ActasDataPort actasDataPort;
    
    public EjecutarAnalisisParentescoService(
            AnalisisParentescoDataPort analisisParentescoDataPort,
            APDDataPort apdDataPort,
            ActasDataPort actasDataPort) {
        this.analisisParentescoDataPort = analisisParentescoDataPort;
        this.apdDataPort = apdDataPort;
        this.actasDataPort = actasDataPort;
    }
    
    @Override
    public AnalisisParentesco ejecutar(DNI dniCiudadano, TipoVinculo tipoVinculoBuscado,
                                      int profundidadAnalisis, String usuarioSolicitante) {
        
        // 1. Validar ciudadano en APD
        Map<String, Object> datosAPD = apdDataPort.validarCiudadano(dniCiudadano.getValor());
        
        if (datosAPD == null || !Boolean.TRUE.equals(datosAPD.get("valido"))) {
            throw new IllegalArgumentException("Ciudadano no válido en APD: " + dniCiudadano);
        }
        
        // 2. Crear ciudadano desde datos de APD
        Ciudadano ciudadanoAnalizado = crearCiudadanoDesdeAPD(dniCiudadano, datosAPD);
        
        // 3. Iniciar análisis (Aggregate Root)
        AnalisisParentesco analisis = AnalisisParentesco.iniciar(
            ciudadanoAnalizado,
            tipoVinculoBuscado,
            profundidadAnalisis,
            usuarioSolicitante
        );
        
        analisis.iniciarEjecucion();
        
        try {
            // 4. Buscar relaciones según el tipo de vínculo solicitado
            List<Map<String, Object>> relacionesEncontradas = 
                buscarRelacionesSegunTipo(dniCiudadano, tipoVinculoBuscado, profundidadAnalisis);
            
            // 5. Procesar cada relación encontrada
            for (Map<String, Object> datosRelacion : relacionesEncontradas) {
                procesarRelacion(analisis, ciudadanoAnalizado, datosRelacion);
            }
            
            // 6. Completar análisis
            analisis.completar();
            
        } catch (Exception e) {
            analisis.marcarComoFallido("Error durante la ejecución: " + e.getMessage());
        }
        
        return analisis;
    }
    
    private Ciudadano crearCiudadanoDesdeAPD(DNI dni, Map<String, Object> datosAPD) {
        String nombreCompleto = (String) datosAPD.get("nombreCompleto");
        LocalDate fechaNacimiento = (LocalDate) datosAPD.get("fechaNacimiento");
        
        return Ciudadano.crear(dni, nombreCompleto, fechaNacimiento);
    }
    
    private List<Map<String, Object>> buscarRelacionesSegunTipo(DNI dni, TipoVinculo tipo,
                                                                 int profundidad) {
        if (tipo.esConsanguineo()) {
            return analisisParentescoDataPort.buscarRelacionesConsanguineas(
                dni.getValor(), profundidad);
        } else {
            return analisisParentescoDataPort.buscarRelacionesAfinidad(
                dni.getValor(), profundidad);
        }
    }
    
    private void procesarRelacion(AnalisisParentesco analisis, Ciudadano ciudadanoOrigen,
                                 Map<String, Object> datosRelacion) {
        
        try {
            // Extraer datos de la relación
            String dniRelacionadoStr = (String) datosRelacion.get("dniRelacionado");
            String tipoRelacionCodigo = (String) datosRelacion.get("tipoRelacion");
            Double porcentajeConfianza = (Double) datosRelacion.get("confianza");
            
            // Crear objetos de dominio
            DNI dniRelacionado = DNI.of(dniRelacionadoStr);
            TipoVinculo tipoVinculo = TipoVinculo.fromCodigo(tipoRelacionCodigo);
            NivelConfianza nivelConfianza = NivelConfianza.fromPorcentaje(porcentajeConfianza);
            
            // Validar acta civil
            boolean actaValidada = actasDataPort.validarActaNacimiento(dniRelacionadoStr);
            
            if (!actaValidada) {
                analisis.registrarInconsistencia(
                    TipoInconsistencia.ACTA_FALTANTE,
                    "No se encontró acta de nacimiento para DNI " + dniRelacionadoStr,
                    List.of()
                );
            }
            
            // Obtener datos del ciudadano relacionado desde APD
            Map<String, Object> datosRelacionadoAPD = 
                apdDataPort.validarCiudadano(dniRelacionadoStr);
            
            if (datosRelacionadoAPD == null) {
                analisis.registrarInconsistencia(
                    TipoInconsistencia.DATOS_INCOMPLETOS,
                    "No se encontraron datos completos para DNI " + dniRelacionadoStr,
                    List.of()
                );
                return;
            }
            
            Ciudadano ciudadanoRelacionado = crearCiudadanoDesdeAPD(
                dniRelacionado, datosRelacionadoAPD);
            
            // Establecer vínculo con validaciones del dominio
            Vinculo vinculo = Vinculo.establecer(
                ciudadanoOrigen,
                ciudadanoRelacionado,
                tipoVinculo,
                nivelConfianza,
                actaValidada
            );
            
            // Registrar vínculo en el análisis
            analisis.registrarVinculoEncontrado(vinculo);
            
        } catch (IllegalArgumentException e) {
            // Las validaciones del dominio arrojaron error
            analisis.registrarInconsistencia(
                TipoInconsistencia.VINCULO_IMPOSIBLE,
                "Vínculo inválido: " + e.getMessage(),
                List.of()
            );
        } catch (Exception e) {
            analisis.registrarInconsistencia(
                TipoInconsistencia.DATOS_INCOMPLETOS,
                "Error al procesar relación: " + e.getMessage(),
                List.of()
            );
        }
    }
}
