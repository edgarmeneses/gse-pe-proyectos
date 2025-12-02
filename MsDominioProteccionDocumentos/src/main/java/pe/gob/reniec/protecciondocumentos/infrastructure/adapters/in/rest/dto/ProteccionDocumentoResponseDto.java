package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

public record ProteccionDocumentoResponseDto(
    Boolean success,
    ProteccionDocumentoDataDto data,
    MetadataDto metadata
) {}
