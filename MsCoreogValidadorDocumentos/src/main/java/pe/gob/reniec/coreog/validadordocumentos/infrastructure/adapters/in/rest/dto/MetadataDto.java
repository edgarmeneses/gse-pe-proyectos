package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa los metadatos de la respuesta
 */
public record MetadataDto(
    String timestamp,
    String correlationId,
    String version,
    String servidorProcesamiento
) {}
