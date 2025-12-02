package pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record ConsultarCertificadoResponseDto(
    String numeroCertificado,
    String titular,
    String emisor,
    LocalDateTime fechaEmision,
    LocalDateTime fechaExpiracion,
    String estado,
    String codigoRespuesta,
    String mensaje
) {
}
