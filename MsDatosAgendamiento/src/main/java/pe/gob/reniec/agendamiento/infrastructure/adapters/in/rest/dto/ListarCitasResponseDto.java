package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ListarCitasResponseDto(
    Boolean success,
    List<CitaDataDto> data,
    PaginacionDto paginacion,
    MetadataDto metadata,
    ErrorDto error
) {}
