package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de response para consultar relaciones de parentesco.
 */
public class ConsultarRelacionesResponseDto {
    
    private Boolean success;
    private ConsultarRelacionesDataDto data;
    private MetadataDto metadata;
    
    public ConsultarRelacionesResponseDto() {
    }
    
    public ConsultarRelacionesResponseDto(Boolean success, ConsultarRelacionesDataDto data, 
                                         MetadataDto metadata) {
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
    
    public ConsultarRelacionesDataDto getData() {
        return data;
    }
    
    public void setData(ConsultarRelacionesDataDto data) {
        this.data = data;
    }
    
    public MetadataDto getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
