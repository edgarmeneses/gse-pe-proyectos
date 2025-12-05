package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO de respuesta para el registro de evaluación de documento.
 */
public class EvaluacionDocumentoResponseDto {

    private Boolean success;
    private EvaluacionDataDto data;
    private MetadataDto metadata;

    public EvaluacionDocumentoResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public EvaluacionDataDto getData() {
        return data;
    }

    public void setData(EvaluacionDataDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
