package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO Request: Crear Documento
 */
public record CrearDocumentoRequestDto(
    String archivoBase64,
    String carpetaId,
    Map<String, Object> metadata
) {}
