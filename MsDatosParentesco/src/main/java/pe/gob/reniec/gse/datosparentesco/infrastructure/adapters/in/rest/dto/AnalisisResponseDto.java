package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record AnalisisResponseDto(
        Boolean success,
        AnalisisDataResponseDto data,
        MetadataDto metadata
) {
}
