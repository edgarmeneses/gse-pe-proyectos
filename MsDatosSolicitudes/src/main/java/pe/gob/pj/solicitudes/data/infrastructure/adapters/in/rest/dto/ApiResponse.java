package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

/**
 * Wrapper genérico para respuestas de API
 * Sigue el estándar: { success, data, pagination?, error? }
 */
public record ApiResponse<T>(
        Boolean success,
        T data,
        PaginacionDto pagination,
        ErrorDto error
) {
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
    
    // DTO interno para errores
    public record ErrorDto(
            String code,
            String message
    ) {
    }
}
