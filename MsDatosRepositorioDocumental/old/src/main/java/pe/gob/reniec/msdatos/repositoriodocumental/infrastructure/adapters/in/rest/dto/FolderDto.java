package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record FolderDto(
    String id,
    Map<String, Object> metadata,
    String path,
    String estadoCarpeta,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
