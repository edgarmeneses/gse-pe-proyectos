package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Item de documento en listados
 */
public record DocumentoItemDto(
    String documentoId,
    String nombreDocumento,
    String rutaDocumento
) {}
