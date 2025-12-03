package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public record DocumentoGeneradoDto(
        String tipoDocumento,
        String numeroOficio,
        String urlDocumento,
        Boolean firmadoDigitalmente,
        String hash
) {
}
