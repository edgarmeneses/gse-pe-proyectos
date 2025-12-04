package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de response para actualizar un análisis de parentesco.
 */
public class ActualizarAnalisisResponseDto {
    
    private Boolean success;
    private ActualizarAnalisisDataDto data;
    private MetadataDto metadata;
    
    public ActualizarAnalisisResponseDto() {
    }
    
    public ActualizarAnalisisResponseDto(Boolean success, ActualizarAnalisisDataDto data, MetadataDto metadata) {
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
    
    public ActualizarAnalisisDataDto getData() {
        return data;
    }
    
    public void setData(ActualizarAnalisisDataDto data) {
        this.data = data;
    }
    
    public MetadataDto getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
