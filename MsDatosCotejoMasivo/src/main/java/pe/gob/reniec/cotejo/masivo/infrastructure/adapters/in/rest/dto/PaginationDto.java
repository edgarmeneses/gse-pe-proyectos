package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

public record PaginationDto(
    Integer page,
    Integer size,
    Integer totalElements,
    Integer totalPages,
    Boolean first,
    Boolean last
) {}
