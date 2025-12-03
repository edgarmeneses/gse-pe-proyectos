package pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto;

public record FirmarDocumentoRequestDto(
    String documento,
    String certificado,
    String password,
    String tipoFirma
) {
}
