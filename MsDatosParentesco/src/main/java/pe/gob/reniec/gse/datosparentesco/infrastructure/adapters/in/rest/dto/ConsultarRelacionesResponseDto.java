package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record ConsultarRelacionesResponseDto(
        Boolean success,
        ConsultarRelacionesDataDto data,
        MetadataDto metadata
) {
}
