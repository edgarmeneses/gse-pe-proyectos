package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record PageDto(
    Integer number,
    Integer size,
    Long totalElements,
    Integer totalPages,
    Boolean hasNext
) {}
