package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

public class VinculosParentescoResponseDto {
    private Boolean success;
    private VinculosParentescoDataDto data;
    private MetadataDto metadata;

    public VinculosParentescoResponseDto() {
    }

    public VinculosParentescoResponseDto(Boolean success, VinculosParentescoDataDto data, MetadataDto metadata) {
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

    public VinculosParentescoDataDto getData() {
        return data;
    }

    public void setData(VinculosParentescoDataDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
