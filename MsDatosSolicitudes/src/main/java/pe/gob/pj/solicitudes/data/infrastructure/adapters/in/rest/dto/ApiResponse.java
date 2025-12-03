package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

/**
 * Wrapper genérico para respuestas de API
 * Sigue el estándar: { success, data, pagination?, error? }
 */
public final class ApiResponse<T> {
    private final Boolean success;
    private final T data;
    private final PaginacionDto pagination;
    private final ErrorDto error;

    public ApiResponse(Boolean success, T data, PaginacionDto pagination, ErrorDto error) {
        this.success = success;
        this.data = data;
        this.pagination = pagination;
        this.error = error;
    }

    // Constructor para respuesta exitosa sin paginación
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null, null);
    }
    
    // Constructor para respuesta exitosa con paginación
    public static <T> ApiResponse<T> success(T data, PaginacionDto pagination) {
        return new ApiResponse<>(true, data, pagination, null);
    }
    
    // Constructor para respuesta de error
    public static <T> ApiResponse<T> error(String code, String message) {
        return new ApiResponse<>(false, null, null, new ErrorDto(code, message));
    }

    public Boolean success() { return success; }
    public T data() { return data; }
    public PaginacionDto pagination() { return pagination; }
    public ErrorDto error() { return error; }

    // DTO interno para errores
    public static final class ErrorDto {
        private final String code;
        private final String message;

        public ErrorDto(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String code() { return code; }
        public String message() { return message; }
    }
}
