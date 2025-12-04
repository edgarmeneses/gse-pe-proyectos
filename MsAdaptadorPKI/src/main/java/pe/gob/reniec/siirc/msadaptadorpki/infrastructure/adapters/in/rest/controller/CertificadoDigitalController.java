package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.siirc.msadaptadorpki.domain.model.SolicitudCertificado;
import pe.gob.reniec.siirc.msadaptadorpki.domain.model.SolicitudNumerosSecuencia;
import pe.gob.reniec.siirc.msadaptadorpki.domain.ports.in.GenerarCertificadoDigitalDnieUseCase;
import pe.gob.reniec.siirc.msadaptadorpki.domain.ports.in.GenerarNumerosSolicitudUseCase;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto.GenerarCertificadoDigitalRequestDto;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto.GenerarCertificadoDigitalResponseDto;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto.GenerarNumerosSolicitudRequestDto;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto.GenerarNumerosSolicitudResponseDto;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.mapper.CertificadoDigitalDtoMapper;

public class CertificadoDigitalController {
    
    private final GenerarCertificadoDigitalDnieUseCase generarCertificadoUseCase;
    private final GenerarNumerosSolicitudUseCase generarNumerosSolicitudUseCase;
    private final CertificadoDigitalDtoMapper mapper;
    
    public CertificadoDigitalController(GenerarCertificadoDigitalDnieUseCase generarCertificadoUseCase,
                                       GenerarNumerosSolicitudUseCase generarNumerosSolicitudUseCase,
                                       CertificadoDigitalDtoMapper mapper) {
        this.generarCertificadoUseCase = generarCertificadoUseCase;
        this.generarNumerosSolicitudUseCase = generarNumerosSolicitudUseCase;
        this.mapper = mapper;
    }
    
    /**
     * Endpoint: POST /api/v1/certificadosDigitales/MsAdaptadorPKI/generarCertificadoDigitalDniE
     * 
     * Headers requeridos:
     * - Authorization: Bearer token
     * - Content-Type: application/json
     * - X-Correlation-ID: UUID para trazabilidad
     * - X-Request-ID: UUID único de la petición
     * - X-Office-Code: Código de la oficina (5 caracteres)
     * - X-PKI-Transaction-ID: ID de transacción PKI
     * 
     * Status codes:
     * - 201: Certificados generados exitosamente
     * - 400: Datos de entrada inválidos
     * - 401: No autorizado (token inválido)
     * - 403: Prohibido (permisos insuficientes)
     * - 404: Ciudadano no encontrado en APD
     * - 409: Conflicto (certificado ya existe)
     * - 422: Error de validación de negocio
     * - 429: Too Many Requests (rate limiting)
     * - 500: Error interno del servidor
     * - 502: Error en servicio PKI externo
     * - 503: Servicio no disponible
     * - 504: Timeout (> 30 segundos)
     */
    public GenerarCertificadoDigitalResponseDto generarCertificadoDigitalDnie(
            GenerarCertificadoDigitalRequestDto request,
            String authorization,
            String correlationId,
            String requestId,
            String officeCode,
            String pkiTransactionId) {
        
        SolicitudCertificado solicitud = mapper.toDomain(request);
        
        GenerarCertificadoDigitalDnieUseCase.GenerarCertificadoDigitalDnieResponse response = 
            generarCertificadoUseCase.ejecutar(solicitud, correlationId, requestId, officeCode, pkiTransactionId);
        
        return mapper.toResponseDto(response);
    }
    
    /**
     * Endpoint: POST /api/v1/certificadosDigitales/MsAdaptadorPKI/generarNumerosSolicitud2
     * 
     * Headers requeridos:
     * - Authorization: Bearer token
     * - Content-Type: application/json
     * - X-Correlation-ID: UUID para trazabilidad
     * - X-Office-Code: Código de la oficina (5 caracteres)
     * 
     * Status codes:
     * - 201: Números generados exitosamente
     * - 400: Datos de entrada inválidos
     * - 401: No autorizado
     * - 403: Prohibido
     * - 422: Error de validación de negocio
     * - 429: Too Many Requests
     * - 500: Error interno
     * - 502: Error en servicio PKI externo
     * - 503: Servicio no disponible
     * - 504: Timeout
     */
    public GenerarNumerosSolicitudResponseDto generarNumerosSolicitud2(
            GenerarNumerosSolicitudRequestDto request,
            String authorization,
            String correlationId,
            String requestId,
            String officeCode) {
        
        SolicitudNumerosSecuencia solicitud = mapper.toNumerosSecuenciaDomain(request);
        
        GenerarNumerosSolicitudUseCase.GenerarNumerosSolicitudResponse response = 
            generarNumerosSolicitudUseCase.ejecutar(solicitud, correlationId, requestId, officeCode);
        
        return mapper.toNumerosSolicitudResponseDto(response);
    }
}
