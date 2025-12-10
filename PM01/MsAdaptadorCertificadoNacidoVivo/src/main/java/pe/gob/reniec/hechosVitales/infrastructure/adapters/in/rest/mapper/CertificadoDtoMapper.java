package pe.gob.reniec.hechosVitales.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.hechosVitales.domain.model.CertificadoNacidoVivo;
import pe.gob.reniec.hechosVitales.infrastructure.adapters.in.rest.dto.CertificadoDataDto;
import pe.gob.reniec.hechosVitales.infrastructure.adapters.in.rest.dto.CertificadoResponseDto;
import pe.gob.reniec.hechosVitales.infrastructure.adapters.in.rest.dto.MetadataDto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Mapper: CertificadoDtoMapper
 * 
 * Mapea entre entidades del dominio y DTOs de infraestructura.
 * Implementación en Java puro, sin anotaciones ni frameworks.
 */
public class CertificadoDtoMapper {
    
    private static final String SERVICE_VERSION = "1.2";
    private static final String PROVEEDOR = "MINSA";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss");
    
    /**
     * Convierte la entidad de dominio CertificadoNacidoVivo a DTO de respuesta.
     * 
     * @param certificado Entidad de dominio
     * @param correlationId ID de correlación
     * @return CertificadoResponseDto
     */
    public CertificadoResponseDto toResponseDto(CertificadoNacidoVivo certificado, String correlationId) {
        if (certificado == null) {
            throw new UnsupportedOperationException("Certificado no puede ser nulo");
        }
        
        // Mapear datos del certificado
        CertificadoDataDto dataDto = new CertificadoDataDto(
            certificado.getMadre().getTipoDocumento().getCodigo(),
            certificado.getMadre().getNumeroDocumento(),
            certificado.getNacimiento().getFecha().format(DATE_FORMATTER),
            certificado.getNacimiento().getHora().format(TIME_FORMATTER),
            certificado.getSexo().getCodigo(),
            certificado.getCodigoRespuesta(),
            certificado.getDescripcionRespuesta()
        );
        
        // Crear metadata
        MetadataDto metadataDto = new MetadataDto(
            obtenerTimestampActual(),
            correlationId,
            SERVICE_VERSION,
            PROVEEDOR
        );
        
        // Construir respuesta
        return new CertificadoResponseDto(true, dataDto, metadataDto);
    }
    
    private String obtenerTimestampActual() {
        return ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}
