package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest.dto.response;

public class ApiResponse<T> {
    private boolean success;
    private T data;
    private MetadataResponse metadata;
    private ErrorResponse error;

    public ApiResponse() {}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MetadataResponse getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataResponse metadata) {
        this.metadata = metadata;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
