package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto;

public record MetadataDto(
    String timestamp,
    String correlationId,
    String version
) {}
