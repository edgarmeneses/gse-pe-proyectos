package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO: Item de carpeta en listados
 */
public record CarpetaItemDto(
    String id,
    Map<String, Object> metadata,
    String createdAt
) {}
