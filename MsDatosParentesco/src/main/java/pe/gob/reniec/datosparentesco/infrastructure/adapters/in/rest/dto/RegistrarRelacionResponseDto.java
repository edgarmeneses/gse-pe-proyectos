package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de response para registrar una relación de parentesco.
 */
public class RegistrarRelacionResponseDto {
    
    private Boolean success;
    private RegistrarRelacionDataDto data;
    private MetadataDto metadata;
    
    public RegistrarRelacionResponseDto() {
    }
    
    public RegistrarRelacionResponseDto(Boolean success, RegistrarRelacionDataDto data, MetadataDto metadata) {
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
    
    public RegistrarRelacionDataDto getData() {
        return data;
    }
    
    public void setData(RegistrarRelacionDataDto data) {
        this.data = data;
    }
    
    public MetadataDto getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
