package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

public record ActualizarDocumentoRequestDto(
    String archivoBase64,
    String carpetaId,
    Map<String, Object> metadata,
    String estadoDocumento
) {}
