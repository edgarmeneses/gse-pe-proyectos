package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.dominioparentesco.domain.model.ResultadoAnalisisParentesco;
import pe.gob.reniec.dominioparentesco.domain.model.SolicitudAnalisisParentesco;
import pe.gob.reniec.dominioparentesco.domain.ports.in.EjecutarAnalisisParentescoUseCase;
import pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto.EjecutarAnalisisRequestDto;
import pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto.EjecutarAnalisisResponseDto;
import pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.mapper.AnalisisParentescoDtoMapper;

/**
 * Controller REST para el microservicio MsDominioParentesco.
 * Representa el endpoint definido en la especificación sin anotaciones de framework.
 */
public class AnalisisParentescoController {
    
    private final EjecutarAnalisisParentescoUseCase ejecutarAnalisisUseCase;
    private final AnalisisParentescoDtoMapper mapper;
    
    public AnalisisParentescoController(EjecutarAnalisisParentescoUseCase ejecutarAnalisisUseCase,
                                       AnalisisParentescoDtoMapper mapper) {
        this.ejecutarAnalisisUseCase = ejecutarAnalisisUseCase;
        this.mapper = mapper;
    }
    
    /**
     * POST /api/v1/parentesco/MsDominioParentesco/analisis/ejecutar
     * Endpoint para ejecutar el análisis de parentesco.
     * 
     * Códigos de respuesta:
     * - 200 OK: Análisis ejecutado exitosamente
     * - 202 Accepted: Análisis iniciado, procesamiento asíncrono en curso
     * - 400 Bad Request: Parámetros inválidos o datos incompletos
     * - 401 Unauthorized: Token JWT inválido, expirado o ausente
     * - 403 Forbidden: Sin permisos para ejecutar análisis de parentesco
     * - 404 Not Found: Ciudadano no encontrado en el sistema APD
     * - 408 Request Timeout: Tiempo de espera agotado al consultar servicios externos
     * - 409 Conflict: Ya existe un análisis activo para esta solicitud y ciudadano
     * - 422 Unprocessable Entity: Nivel de complejidad no válido para el tipo de vínculo solicitado
     * - 429 Too Many Requests: Límite de rate limit excedido
     * - 500 Internal Server Error: Error interno del servicio
     * - 502 Bad Gateway: MsSagaAPD o MsDatosActas no disponible
     * - 503 Service Unavailable: Servicio temporalmente no disponible
     * - 504 Gateway Timeout: Timeout en consulta a servicios externos
     * 
     * @param request Datos de la solicitud de análisis
     * @param authorization Bearer token JWT para autenticación del usuario
     * @param contentType Content-Type header (application/json)
     * @param correlationId UUID de correlación para trazabilidad end-to-end
     * @param officeCode Código de oficina RENIEC formato: ORG-LIMA-CENTRO
     * @param userRole Rol del usuario: TECNICO_VINCULO, COORDINADOR_VINCULO
     * @param idempotencyKey UUID de clave de idempotencia para evitar duplicados
     * @return Response con el resultado del análisis
     */
    public EjecutarAnalisisResponseDto ejecutarAnalisis(EjecutarAnalisisRequestDto request,
                                                       String authorization,
                                                       String contentType,
                                                       String correlationId,
                                                       String officeCode,
                                                       String userRole,
                                                       String idempotencyKey) {
        // Convertir DTO a objeto del dominio
        SolicitudAnalisisParentesco solicitud = mapper.toDomain(request);
        
        // Ejecutar el caso de uso
        ResultadoAnalisisParentesco resultado = ejecutarAnalisisUseCase.ejecutar(solicitud);
        
        // Convertir resultado a DTO
        return mapper.toDto(resultado, correlationId);
    }
}
