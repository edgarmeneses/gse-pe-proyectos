package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto;

/**
 * DTO de respuesta: Resultado completo del análisis de actas
 */
public class AnalisisResponseDto {

    private Boolean success;
    private AnalisisDataDto data;
    private MetadataDto metadata;

    public AnalisisResponseDto() {
    }

    public AnalisisResponseDto(Boolean success, AnalisisDataDto data, MetadataDto metadata) {
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

    public AnalisisDataDto getData() {
        return data;
    }

    public void setData(AnalisisDataDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
