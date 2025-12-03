package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO Response: Consultar Documento
 */
public record ConsultarDocumentoResponseDto(
    String archivo,
    String carpetaId,
    Map<String, Object> metadata,
    String estadoDocumento
) {}
