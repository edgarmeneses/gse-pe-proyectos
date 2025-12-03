package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.controller;

import pe.gob.sunat.gse.coreog.certificadosdigitales.domain.model.CertificadoDigital;
import pe.gob.sunat.gse.coreog.certificadosdigitales.domain.ports.in.ObtenerCertificadoDigitalUseCase;
import pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto.ObtenerCertificadoDigitalRequestDto;
import pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto.ObtenerCertificadoDigitalResponseDto;
import pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto.ErrorResponseDto;
import pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.mapper.CertificadoDigitalDtoMapper;
import java.util.List;

/**
 * Controlador REST para certificados digitales (Adaptador de entrada)
 * Define el contrato HTTP sin framework específico
 * 
 * Endpoint: POST /api/v1/coreog/MsCoreogCertificadosDigitales/obtener-certificado-digital
 * 
 * Headers requeridos:
 * - Authorization: Bearer token de autenticación
 * - Content-Type: application/json
 * - X-Correlation-ID: UUID de trazabilidad entre microservicios
 * - X-Request-ID: UUID único de la solicitud
 * - X-Office-Code: Código de oficina SUNAT
 * - X-Device-ID: Identificador del dispositivo
 * - X-Channel: Canal (web/mobile/kiosk)
 * 
 * Códigos de respuesta:
 * - 201 Created: Certificado emitido exitosamente
 * - 400 Bad Request: Validación de datos fallida
 * - 401 Unauthorized: Token inválido o expirado
 * - 403 Forbidden: No tiene permisos
 * - 404 Not Found: Ciudadano no encontrado
 * - 409 Conflict: Certificado ya existe
 * - 422 Unprocessable Entity: Regla de negocio fallida
 * - 429 Too Many Requests: Límite de tasa excedido
 * - 500 Internal Server Error: Error interno
 * - 502 Bad Gateway: Error MsAdaptadorPKI
 * - 503 Service Unavailable: Servicio no disponible
 * - 504 Gateway Timeout: Timeout MsAdaptadorPKI
 */
public class CertificadoDigitalController {
    
    private final ObtenerCertificadoDigitalUseCase obtenerCertificadoDigitalUseCase;
    private final CertificadoDigitalDtoMapper mapper;
    
    public CertificadoDigitalController(ObtenerCertificadoDigitalUseCase obtenerCertificadoDigitalUseCase,
                                       CertificadoDigitalDtoMapper mapper) {
        this.obtenerCertificadoDigitalUseCase = obtenerCertificadoDigitalUseCase;
        this.mapper = mapper;
    }
    
    /**
     * POST /api/v1/coreog/MsCoreogCertificadosDigitales/obtener-certificado-digital
     * Emite certificados digitales ejecutando flujo de 2 pasos con MsAdaptadorPKI
     * 
     * @param requestDto Datos completos de solicitud con 4 secciones
     * @return Response 201 con success, data (transaccion, ciudadano, certificados, pasosProceso, auditoria) y metadata
     */
    public ObtenerCertificadoDigitalResponseDto obtenerCertificadoDigital(ObtenerCertificadoDigitalRequestDto requestDto) {
        // Ejecutar caso de uso (coordina 2 pasos con MsAdaptadorPKI)
        List<CertificadoDigital> certificados = obtenerCertificadoDigitalUseCase.obtener(
            requestDto.getSolicitud(),
            requestDto.getCiudadano(),
            requestDto.getConfiguracionCertificados(),
            requestDto.getMetadatos()
        );
        
        // Mapear a DTO de respuesta con estructura success/data/metadata
        return mapper.toResponseDto(certificados, requestDto);
    }
    
    /**
     * Manejo de errores (retorna estructura ErrorResponseDto)
     * 
     * @param exception Excepción capturada
     * @param statusCode Código HTTP correspondiente
     * @return ErrorResponseDto con estructura error{tipo, titulo, estado, errores[]}
     */
    public ErrorResponseDto handleError(Exception exception, int statusCode) {
        // Implementación pendiente: mapeo de excepciones a ErrorResponseDto
        // según tipo de error (validación, negocio, infraestructura)
        throw new UnsupportedOperationException("Implementación pendiente: manejo de errores");
    }
}
