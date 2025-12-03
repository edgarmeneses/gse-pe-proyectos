package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Detalle completo de documento
 */
public record DocumentoDetalleDto(
    String documentoId,
    String nombreDocumento,
    String tipoDocumento,
    String rutaDocumento,
    String carpetaId,
    String estadoDocumento,
    String mimeType,
    Integer tamanioBytes,
    String createdAt,
    String updatedAt
) {}
