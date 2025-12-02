package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record MetadataResponseDto(
    LocalDateTime timestamp,
    String correlationId,
    String version,
    ServiciosConsultadosResponseDto serviciosConsultados
) {}
