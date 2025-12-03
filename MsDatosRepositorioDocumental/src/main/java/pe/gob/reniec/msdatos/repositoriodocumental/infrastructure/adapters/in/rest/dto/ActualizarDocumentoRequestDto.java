package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO Request: Actualizar Documento
 */
public record ActualizarDocumentoRequestDto(
    String archivoBase64,
    String carpetaId,
    Map<String, Object> metadata,
    String estadoDocumento
) {}
