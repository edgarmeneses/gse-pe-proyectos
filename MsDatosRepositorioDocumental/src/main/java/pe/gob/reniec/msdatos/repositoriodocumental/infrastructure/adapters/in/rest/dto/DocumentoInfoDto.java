package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

public record DocumentoInfoDto(
    String documentoId,
    String nombreDocumento,
    String rutaDocumento
) {}
