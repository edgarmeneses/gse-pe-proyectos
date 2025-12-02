package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record TiposParentescoResponseDto(
        Boolean success,
        TiposParentescoDataDto data,
        MetadataDto metadata
) {
}
