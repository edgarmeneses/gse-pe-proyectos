package pe.gob.reniec.cotejo.masivo.application.service;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.domain.model.ResumenResultados;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.EjecutarCotejoUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.EjecucionDataPort;

import java.util.List;

public class EjecutarCotejoService implements EjecutarCotejoUseCase {
    private final EjecucionDataPort ejecucionDataPort;

    public EjecutarCotejoService(EjecucionDataPort ejecucionDataPort) {
        this.ejecucionDataPort = ejecucionDataPort;
    }

    public ResultadoEjecucionCotejo ejecutar(SolicitudCotejo solicitud) {
        Ejecucion ejecucion = new Ejecucion(
            solicitud.getSolicitudId(),
            solicitud.getCodigoOrganizacion(),
            solicitud.getNombreOrganizacion(),
            solicitud.getCodigoEnvio(),
            solicitud.getNumeroLote(),
            (long) solicitud.getRegistros().size(),
            solicitud.getDocumentoSustento(),
            solicitud.getObservaciones(),
            solicitud.getIndicadorDomicilio(),
            solicitud.getCodigoPrograma(),
            solicitud.getUsuarioCreacion()
        );

        Ejecucion ejecucionCreada = ejecucionDataPort.crearEjecucion(ejecucion);
        
        String ejecucionId = ejecucionCreada.getEjecucionId();
        
        for (RegistroEntrada registro : solicitud.getRegistros()) {
            registro.setEjecucionId(ejecucionId);
        }
        
        EjecucionDataPort.ResultadoRegistroBatch resultadoRegistro = 
            ejecucionDataPort.registrarRegistros(ejecucionId, solicitud.getRegistros());
        
        if (resultadoRegistro.getTotalRegistrosRechazados() > 0) {
            return new ResultadoEjecucionCotejo(
                ejecucionId,
                "RECHAZADO_PARCIAL",
                "Algunos registros fueron rechazados",
                ejecucionCreada
            );
        }
        
        ejecucionCreada.iniciarProceso();
        
        List<ResultadoCotejo> resultadosCotejo = ejecutarCotejoPadron(ejecucionId, solicitud.getRegistros());
        
        EjecucionDataPort.ResultadoCotejoBatch resultadoCotejoBatch = 
            ejecucionDataPort.registrarResultados(ejecucionId, resultadosCotejo);
        
        ResumenResultados resumen = calcularResumen(resultadosCotejo);
        ejecucionCreada.finalizarProceso(resumen);
        
        Ejecucion ejecucionFinal = ejecucionDataPort.consultarEjecucion(ejecucionId);
        
        return new ResultadoEjecucionCotejo(
            ejecucionId,
            "COMPLETADO",
            "Cotejo masivo ejecutado exitosamente",
            ejecucionFinal
        );
    }
    
    private List<ResultadoCotejo> ejecutarCotejoPadron(String ejecucionId, List<RegistroEntrada> registros) {
        throw new UnsupportedOperationException("Integración con Padrón RENIEC pendiente de implementación");
    }
    
    private ResumenResultados calcularResumen(List<ResultadoCotejo> resultados) {
        long correctos = resultados.stream()
            .filter(r -> "CORRECTO".equals(r.getCodigoResultado()))
            .count();
        
        long dniNoExiste = resultados.stream()
            .filter(r -> "DNI_NO_EXISTE".equals(r.getCodigoResultado()))
            .count();
        
        long datosNoCoinciden = resultados.stream()
            .filter(r -> "DATOS_NO_COINCIDEN".equals(r.getCodigoResultado()))
            .count();
        
        long errores = resultados.stream()
            .filter(r -> "ERROR_SISTEMA".equals(r.getCodigoResultado()))
            .count();
        
        return new ResumenResultados(correctos, dniNoExiste, datosNoCoinciden, errores);
    }
}
