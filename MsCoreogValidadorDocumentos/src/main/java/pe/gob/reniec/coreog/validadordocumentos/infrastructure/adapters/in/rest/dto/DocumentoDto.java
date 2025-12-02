package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa un documento en la petición
 */
public record DocumentoDto(
    String documentoId,
    String tipoDocumental,
    String nombreArchivo,
    String rutaGestorDocumental,
    String hashSHA256,
    String formatoDocumento,
    Long tamanioBytes,
    Boolean requiereValidacionIA
) {}
