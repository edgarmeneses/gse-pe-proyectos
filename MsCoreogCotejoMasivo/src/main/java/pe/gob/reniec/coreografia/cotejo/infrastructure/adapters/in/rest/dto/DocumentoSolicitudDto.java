package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

public record DocumentoSolicitudDto(
    String tipo,
    String nombre,
    String urlDocumento,
    String hashDocumento
) {}
