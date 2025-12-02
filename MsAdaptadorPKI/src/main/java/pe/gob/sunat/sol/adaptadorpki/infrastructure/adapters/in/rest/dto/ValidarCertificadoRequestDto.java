package pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record ValidarCertificadoRequestDto(
    String certificado,
    LocalDateTime fechaValidacion
) {
}
