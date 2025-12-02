package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record RelacionParentescoResponseDto(
        Boolean success,
        RelacionParentescoDataDto data,
        MetadataDto metadata
) {
}
