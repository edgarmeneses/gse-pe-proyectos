package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

public record MetadataDto(
    String timestamp,
    String correlationId,
    String version,
    String tiempoRespuesta
) {}
