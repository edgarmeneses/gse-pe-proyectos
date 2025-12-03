package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

/**
 * DTO para paginación de respuestas API
 * Formato estándar de la API REST
 */
public record PaginacionDto(
        Integer page,
        Integer size,
        Long totalElements,
        Integer totalPages,
        Boolean first,
        Boolean last
) {
}
