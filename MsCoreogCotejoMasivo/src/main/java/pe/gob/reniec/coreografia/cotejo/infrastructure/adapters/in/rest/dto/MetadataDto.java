package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

public record MetadataDto(
    String timestamp,
    String correlationId,
    String version,
    String tiempoRespuesta
) {}
