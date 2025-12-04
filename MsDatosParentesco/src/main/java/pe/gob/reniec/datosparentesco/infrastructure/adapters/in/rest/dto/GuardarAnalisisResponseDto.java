package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de response para guardar un análisis de parentesco.
 */
public class GuardarAnalisisResponseDto {
    
    private Boolean success;
    private GuardarAnalisisDataDto data;
    private MetadataDto metadata;
    
    public GuardarAnalisisResponseDto() {
    }
    
    public GuardarAnalisisResponseDto(Boolean success, GuardarAnalisisDataDto data, MetadataDto metadata) {
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
    
    public GuardarAnalisisDataDto getData() {
        return data;
    }
    
    public void setData(GuardarAnalisisDataDto data) {
        this.data = data;
    }
    
    public MetadataDto getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
