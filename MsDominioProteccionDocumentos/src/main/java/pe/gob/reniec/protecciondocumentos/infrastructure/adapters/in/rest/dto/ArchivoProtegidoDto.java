package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

public record ArchivoProtegidoDto(
    String repositorioId,
    String documentoId,
    String nombreArchivo,
    int tamanioBytes,
    String formatoSalida,
    String checksumSHA256
) {}
