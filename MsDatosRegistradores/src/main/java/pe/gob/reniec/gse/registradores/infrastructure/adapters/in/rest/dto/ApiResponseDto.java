package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Response estándar con éxito
 */
public class ApiResponseDto<T> {
    private Boolean success;
    private T data;
    private MetadataDto metadata;

    public ApiResponseDto() {
    }

    public ApiResponseDto(Boolean success, T data, MetadataDto metadata) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
