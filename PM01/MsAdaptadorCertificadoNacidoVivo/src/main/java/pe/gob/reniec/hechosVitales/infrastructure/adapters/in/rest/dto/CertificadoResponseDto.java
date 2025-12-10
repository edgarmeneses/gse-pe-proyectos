package pe.gob.reniec.hechosVitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO de Respuesta: CertificadoResponseDto
 * 
 * Representa la estructura completa de respuesta del endpoint,
 * incluyendo data, metadata y manejo de success.
 */
public class CertificadoResponseDto {
    
    private Boolean success;
    private CertificadoDataDto data;
    private MetadataDto metadata;
    
    public CertificadoResponseDto() {
    }
    
    public CertificadoResponseDto(Boolean success, CertificadoDataDto data, MetadataDto metadata) {
        this.success = success;
        this.data = data;
        this.metadata = metadata;
    }
    
    public Boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    
    public CertificadoDataDto getData() {
        return data;
    }
    
    public void setData(CertificadoDataDto data) {
        this.data = data;
    }
    
    public MetadataDto getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
