package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record DisponibilidadResponseDto(
    Boolean success,
    DisponibilidadDataDto data,
    MetadataDto metadata,
    ErrorDto error
) {}
