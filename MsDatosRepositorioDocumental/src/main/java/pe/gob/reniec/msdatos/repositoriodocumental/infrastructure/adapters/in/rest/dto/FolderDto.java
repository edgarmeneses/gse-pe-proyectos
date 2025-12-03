package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO: Información de carpeta
 */
public record FolderDto(
    String id,
    Map<String, Object> metadata,
    String path,
    String estadoCarpeta,
    String createdAt,
    String updatedAt
) {}
