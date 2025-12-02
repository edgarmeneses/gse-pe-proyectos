package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record ActualizarAnalisisResponseDto(
        Boolean success,
        ActualizarAnalisisDataDto data,
        MetadataDto metadata
) {
}
