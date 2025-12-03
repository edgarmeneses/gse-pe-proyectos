package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO: Información detallada de documento
 */
public record DocumentoInfoDto(
    String id,
    Map<String, Object> metadata,
    String createdAt
) {}
