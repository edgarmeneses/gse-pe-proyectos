package pe.com.gse.adaptadorbcp.infrastructure.adapters.in.rest.controller;

import pe.com.gse.adaptadorbcp.domain.model.RespuestaBCP;
import pe.com.gse.adaptadorbcp.domain.model.SolicitudBCP;
import pe.com.gse.adaptadorbcp.domain.ports.in.ProcesarSolicitudUseCase;
import pe.com.gse.adaptadorbcp.infrastructure.adapters.in.rest.dto.RespuestaBCPResponseDto;
import pe.com.gse.adaptadorbcp.infrastructure.adapters.in.rest.dto.SolicitudBCPRequestDto;
import pe.com.gse.adaptadorbcp.infrastructure.adapters.in.rest.mapper.BCPDtoMapper;

/**
 * Controller REST: AdaptadorBCPController
 * Maneja los endpoints del API REST
 * 
 * Endpoint: POST /api/v1/adaptador/procesar
 * Sin anotaciones de frameworks - Java puro
 */
public class AdaptadorBCPController {
    
    private final ProcesarSolicitudUseCase procesarSolicitudUseCase;
    private final BCPDtoMapper mapper;
    
    public AdaptadorBCPController(
            ProcesarSolicitudUseCase procesarSolicitudUseCase,
            BCPDtoMapper mapper) {
        this.procesarSolicitudUseCase = procesarSolicitudUseCase;
        this.mapper = mapper;
    }
    
    /**
     * Procesa una solicitud hacia BCP
     * POST /api/v1/adaptador/procesar
     * 
     * @param request DTO con los datos de la solicitud
     * @return DTO con la respuesta del BCP
     */
    public RespuestaBCPResponseDto procesar(SolicitudBCPRequestDto request) {
        // Implementación stub - Lógica pendiente
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
