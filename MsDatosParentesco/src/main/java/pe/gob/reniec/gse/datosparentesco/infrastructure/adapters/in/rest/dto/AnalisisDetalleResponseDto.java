package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record AnalisisDetalleResponseDto(
        Boolean success,
        AnalisisDetalleDataDto data,
        MetadataDto metadata
) {
}
