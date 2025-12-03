package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record DocumentoItemDto(
    String id,
    Map<String, Object> metadata,
    LocalDateTime createdAt
) {}
