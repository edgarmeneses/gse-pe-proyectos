package pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record FirmarDocumentoResponseDto(
    String documentoFirmado,
    LocalDateTime fechaFirma,
    String codigoRespuesta,
    String mensaje
) {
}
