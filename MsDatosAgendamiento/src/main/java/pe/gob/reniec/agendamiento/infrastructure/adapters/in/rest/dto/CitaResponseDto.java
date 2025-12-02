package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record CitaResponseDto(
    Boolean success,
    CitaDataDto data,
    MetadataDto metadata,
    ErrorDto error
) {}
