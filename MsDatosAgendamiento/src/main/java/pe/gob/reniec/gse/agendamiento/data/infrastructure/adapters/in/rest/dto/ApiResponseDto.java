package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto;

public record ApiResponseDto<T>(
    Boolean success,
    T data,
    MetadataDto metadata,
    ErrorDto error
) {}
