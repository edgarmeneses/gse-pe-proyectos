package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record AnalisisListaResponseDto(
        Boolean success,
        AnalisisListaDataDto data,
        MetadataDto metadata
) {
}
