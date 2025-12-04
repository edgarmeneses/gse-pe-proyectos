package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de response para consultar un análisis de parentesco.
 */
public class ConsultarAnalisisResponseDto {
    
    private Boolean success;
    private ConsultarAnalisisDataDto data;
    private MetadataDto metadata;
    
    public ConsultarAnalisisResponseDto() {
    }
    
    public ConsultarAnalisisResponseDto(Boolean success, ConsultarAnalisisDataDto data, MetadataDto metadata) {
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
    
    public ConsultarAnalisisDataDto getData() {
        return data;
    }
    
    public void setData(ConsultarAnalisisDataDto data) {
        this.data = data;
    }
    
    public MetadataDto getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
