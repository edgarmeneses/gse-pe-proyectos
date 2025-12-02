package pe.com.organizacion.cotejomasivo.infrastructure.adapters.in.rest.controller;

import pe.com.organizacion.cotejomasivo.domain.model.CotejoMasivo;
import pe.com.organizacion.cotejomasivo.domain.model.CriterioCotejo;
import pe.com.organizacion.cotejomasivo.domain.model.ResultadosPaginados;
import pe.com.organizacion.cotejomasivo.domain.ports.in.ConsultarCotejoMasivoUseCase;
import pe.com.organizacion.cotejomasivo.domain.ports.in.EjecutarCotejoMasivoUseCase;
import pe.com.organizacion.cotejomasivo.domain.ports.in.ObtenerResultadosCotejoMasivoUseCase;
import pe.com.organizacion.cotejomasivo.infrastructure.adapters.in.rest.dto.*;
import pe.com.organizacion.cotejomasivo.infrastructure.adapters.in.rest.mapper.CotejoMasivoDtoMapper;

import java.util.List;

/**
 * Controlador REST: CotejoMasivoController
 * Maneja los endpoints HTTP para el microservicio de cotejo masivo
 * NOTA: Este es un POJO sin anotaciones de framework
 */
public class CotejoMasivoController {
    
    private final EjecutarCotejoMasivoUseCase ejecutarCotejoMasivoUseCase;
    private final ConsultarCotejoMasivoUseCase consultarCotejoMasivoUseCase;
    private final ObtenerResultadosCotejoMasivoUseCase obtenerResultadosCotejoMasivoUseCase;
    private final CotejoMasivoDtoMapper mapper;
    
    public CotejoMasivoController(
            EjecutarCotejoMasivoUseCase ejecutarCotejoMasivoUseCase,
            ConsultarCotejoMasivoUseCase consultarCotejoMasivoUseCase,
            ObtenerResultadosCotejoMasivoUseCase obtenerResultadosCotejoMasivoUseCase,
            CotejoMasivoDtoMapper mapper) {
        this.ejecutarCotejoMasivoUseCase = ejecutarCotejoMasivoUseCase;
        this.consultarCotejoMasivoUseCase = consultarCotejoMasivoUseCase;
        this.obtenerResultadosCotejoMasivoUseCase = obtenerResultadosCotejoMasivoUseCase;
        this.mapper = mapper;
    }
    
    /**
     * POST /api/v1/cotejo-masivo/ejecutar
     * Ejecuta un proceso de cotejo masivo
     */
    public EjecutarCotejoMasivoResponseDto ejecutar(EjecutarCotejoMasivoRequestDto request) {
        // Convertir DTOs a objetos de dominio
        List<CriterioCotejo> criteriosCotejo = mapper.toDomainCriterioList(request.criteriosCotejo());
        
        // Ejecutar caso de uso
        CotejoMasivo cotejoMasivo = ejecutarCotejoMasivoUseCase.ejecutar(
            criteriosCotejo,
            request.usuarioSolicitante()
        );
        
        // Convertir resultado a DTO de respuesta
        return mapper.toEjecutarResponseDto(
            cotejoMasivo,
            201L,
            "Proceso de cotejo masivo iniciado exitosamente"
        );
    }
    
    /**
     * GET /api/v1/cotejo-masivo/estado/{idEjecucion}
     * Consulta el estado de una ejecución de cotejo masivo
     */
    public ConsultarCotejoMasivoResponseDto consultarEstado(String idEjecucion) {
        // Ejecutar caso de uso
        CotejoMasivo cotejoMasivo = consultarCotejoMasivoUseCase.consultar(idEjecucion);
        
        // Convertir resultado a DTO de respuesta
        if (cotejoMasivo == null) {
            return mapper.toConsultarResponseDto(null, 404L, "Ejecución no encontrada");
        }
        
        return mapper.toConsultarResponseDto(
            cotejoMasivo,
            200L,
            "Consulta exitosa"
        );
    }
    
    /**
     * GET /api/v1/cotejo-masivo/resultados/{idEjecucion}
     * Obtiene los resultados paginados de un cotejo masivo
     */
    public ObtenerResultadosCotejoMasivoResponseDto obtenerResultados(
            String idEjecucion,
            Long pagina,
            Long tamanio,
            String estadoCotejo) {
        
        // Ejecutar caso de uso
        ResultadosPaginados resultadosPaginados = obtenerResultadosCotejoMasivoUseCase.obtenerResultados(
            idEjecucion,
            pagina,
            tamanio,
            estadoCotejo
        );
        
        // Convertir resultado a DTO de respuesta
        if (resultadosPaginados == null) {
            return mapper.toObtenerResultadosResponseDto(null, 404L, "Ejecución no encontrada");
        }
        
        return mapper.toObtenerResultadosResponseDto(
            resultadosPaginados,
            200L,
            "Resultados obtenidos exitosamente"
        );
    }
}
