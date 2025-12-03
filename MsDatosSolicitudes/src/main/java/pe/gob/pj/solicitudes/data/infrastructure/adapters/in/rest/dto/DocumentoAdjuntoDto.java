package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public record DocumentoAdjuntoDto(
        String tipo,
        String nombre,
        Long tamanioBytes,
        String mimeType,
        String checksum
) {
}
