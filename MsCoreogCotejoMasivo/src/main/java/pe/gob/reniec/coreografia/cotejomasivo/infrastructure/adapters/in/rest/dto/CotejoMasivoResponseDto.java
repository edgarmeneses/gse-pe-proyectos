package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO - Response completo para cotejo masivo
 */
public class CotejoMasivoResponseDto {
    
    private Boolean success;
    private DataResponseDto data;
    private MetadataDto metadata;
    
    public CotejoMasivoResponseDto() {
    }
    
    public Boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    
    public DataResponseDto getData() {
        return data;
    }
    
    public void setData(DataResponseDto data) {
        this.data = data;
    }
    
    public MetadataDto getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
