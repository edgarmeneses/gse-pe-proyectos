package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record MetadataDto(
    LocalDateTime timestamp,
    String correlationId,
    String version
) {}
