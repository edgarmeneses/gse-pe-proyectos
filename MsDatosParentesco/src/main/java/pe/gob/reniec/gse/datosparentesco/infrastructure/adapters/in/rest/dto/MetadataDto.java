package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record MetadataDto(
        String timestamp,
        String correlationId,
        String version
) {
}
