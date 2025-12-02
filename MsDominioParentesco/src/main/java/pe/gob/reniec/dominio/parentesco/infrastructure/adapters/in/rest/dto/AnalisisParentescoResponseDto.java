package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

public record AnalisisParentescoResponseDto(
    Boolean success,
    AnalisisParentescoDataResponseDto data,
    MetadataResponseDto metadata
) {}
