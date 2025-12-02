package pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record ValidarCertificadoResponseDto(
    Boolean esValido,
    LocalDateTime fechaExpiracion,
    String emisor,
    String titular,
    String codigoRespuesta,
    String mensaje
) {
}
