package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO Response para ejecutar análisis de parentesco.
 */
public class EjecutarAnalisisResponseDto {
    private Boolean success;
    private EjecutarAnalisisDataDto data;
    private MetadataDto metadata;

    public EjecutarAnalisisResponseDto() {}

    public EjecutarAnalisisResponseDto(Boolean success, EjecutarAnalisisDataDto data, MetadataDto metadata) {
        this.success = success;
        this.data = data;
        this.metadata = metadata;
    }

    public Boolean getSuccess() { return success; }
    public void setSuccess(Boolean success) { this.success = success; }

    public EjecutarAnalisisDataDto getData() { return data; }
    public void setData(EjecutarAnalisisDataDto data) { this.data = data; }

    public MetadataDto getMetadata() { return metadata; }
    public void setMetadata(MetadataDto metadata) { this.metadata = metadata; }
}
