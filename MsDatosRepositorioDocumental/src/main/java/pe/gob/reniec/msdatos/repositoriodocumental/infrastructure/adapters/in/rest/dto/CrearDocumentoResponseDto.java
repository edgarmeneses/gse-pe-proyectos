package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO Response: Crear Documento
 */
public record CrearDocumentoResponseDto(
    String id,
    Object metadata,
    String createdAt,
    String estadoDocumento
) {}
