package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record DocumentoResponseDto(
    String id,
    Map<String, Object> metadata,
    LocalDateTime createdAt,
    String estadoDocumento
) {}
