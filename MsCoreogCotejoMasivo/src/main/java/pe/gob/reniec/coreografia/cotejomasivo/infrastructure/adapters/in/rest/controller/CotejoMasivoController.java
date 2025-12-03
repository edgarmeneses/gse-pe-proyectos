package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.coreografia.cotejomasivo.domain.model.ResultadoRegistroSolicitud;
import pe.gob.reniec.coreografia.cotejomasivo.domain.model.SolicitudCotejoMasivo;
import pe.gob.reniec.coreografia.cotejomasivo.domain.ports.in.IniciarCotejoMasivoUseCase;
import pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto.CotejoMasivoRequestDto;
import pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto.CotejoMasivoResponseDto;
import pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto.MetadataDto;
import pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.mapper.CotejoMasivoDtoMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Controller REST - Maneja las peticiones HTTP para cotejo masivo
 * Clase POJO sin anotaciones de frameworks
 */
public class CotejoMasivoController {
    
    private final IniciarCotejoMasivoUseCase iniciarCotejoMasivoUseCase;
    private final CotejoMasivoDtoMapper mapper;
    
    public CotejoMasivoController(IniciarCotejoMasivoUseCase iniciarCotejoMasivoUseCase, 
                                  CotejoMasivoDtoMapper mapper) {
        this.iniciarCotejoMasivoUseCase = iniciarCotejoMasivoUseCase;
        this.mapper = mapper;
    }
    
    /**
     * Endpoint POST /api/v1/ciudadano/MsCoreogCotejoMasivo
     * Inicia el proceso de cotejo masivo
     * 
     * @param request Request DTO
     * @param authorization Bearer token JWT
     * @param correlationId X-Correlation-ID
     * @param officeCode X-Office-Code
     * @param userRole X-User-Role
     * @param requestSource X-Request-Source
     * @param idempotencyKey X-Idempotency-Key
     * @return Response DTO con status 201 Created
     */
    public CotejoMasivoResponseDto iniciarCotejoMasivo(
            CotejoMasivoRequestDto request,
            String authorization,
            String correlationId,
            String officeCode,
            String userRole,
            String requestSource,
            String idempotencyKey) {
        
        long startTime = System.currentTimeMillis();
        
        // Convertir DTO a modelo de dominio
        SolicitudCotejoMasivo solicitud = mapper.toDomain(request);
        
        // Ejecutar caso de uso
        ResultadoRegistroSolicitud resultadoDominio = iniciarCotejoMasivoUseCase.iniciarCotejo(
            solicitud, 
            correlationId, 
            officeCode, 
            userRole, 
            requestSource, 
            idempotencyKey
        );
        
        // Convertir respuesta de dominio a DTO
        CotejoMasivoResponseDto response = mapper.toResponseDto(resultadoDominio);
        
        // Agregar success y metadata
        response.setSuccess(true);
        
        MetadataDto metadata = new MetadataDto();
        metadata.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        metadata.setCorrelationId(correlationId);
        metadata.setVersion("v1");
        
        long elapsedTime = System.currentTimeMillis() - startTime;
        metadata.setTiempoRespuesta(elapsedTime + "ms");
        
        response.setMetadata(metadata);
        
        return response;
    }
}
