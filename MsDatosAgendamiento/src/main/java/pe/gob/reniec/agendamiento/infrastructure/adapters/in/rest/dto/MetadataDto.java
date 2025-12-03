package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record MetadataDto(
    String timestamp,
    String correlationId,
    String version
) {}
