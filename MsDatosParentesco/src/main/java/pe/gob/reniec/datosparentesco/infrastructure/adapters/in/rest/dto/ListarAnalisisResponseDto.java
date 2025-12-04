package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de response para listar análisis de parentesco.
 */
public class ListarAnalisisResponseDto {
    
    private Boolean success;
    private ListarAnalisisDataDto data;
    private MetadataDto metadata;
    
    public ListarAnalisisResponseDto() {
    }
    
    public ListarAnalisisResponseDto(Boolean success, ListarAnalisisDataDto data, MetadataDto metadata) {
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
    
    public ListarAnalisisDataDto getData() {
        return data;
    }
    
    public void setData(ListarAnalisisDataDto data) {
        this.data = data;
    }
    
    public MetadataDto getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
