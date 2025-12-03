package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record ExcepcionHorariaResponseDto(
    Boolean success,
    ExcepcionHorariaDataDto data,
    MetadataDto metadata,
    ErrorDto error
) {}
