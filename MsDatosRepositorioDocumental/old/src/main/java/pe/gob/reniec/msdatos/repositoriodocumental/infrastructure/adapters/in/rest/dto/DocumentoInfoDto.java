package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record DocumentoInfoDto(
    String documentoId,
    String nombreDocumento,
    String tipoDocumento,
    String rutaDocumento,
    String carpetaId,
    String estadoDocumento,
    String mimeType,
    Integer tamanioBytes,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
