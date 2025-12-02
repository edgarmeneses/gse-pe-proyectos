package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record MetadataDto(
    LocalDateTime timestamp,
    String correlationId,
    String version
) {}
