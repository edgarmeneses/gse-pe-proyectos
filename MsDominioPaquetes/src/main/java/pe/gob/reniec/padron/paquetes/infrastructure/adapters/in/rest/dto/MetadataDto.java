package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record MetadataDto(
    LocalDateTime timestamp,
    String correlationId,
    String version,
    String tiempoRespuesta
) {}
