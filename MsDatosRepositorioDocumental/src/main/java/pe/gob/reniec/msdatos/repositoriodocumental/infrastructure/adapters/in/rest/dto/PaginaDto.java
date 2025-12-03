package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Información de paginación
 */
public record PaginaDto(
    Integer number,
    Integer size,
    Long totalElements,
    Integer totalPages,
    Boolean hasNext,
    Boolean hasPrevious
) {}
