package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

/**
 * DTO Record para metadata de la respuesta
 */
public record MetadataResponseDto(
    String timestamp,
    String correlationId,
    String version,
    String tiempoRespuesta
) {}
