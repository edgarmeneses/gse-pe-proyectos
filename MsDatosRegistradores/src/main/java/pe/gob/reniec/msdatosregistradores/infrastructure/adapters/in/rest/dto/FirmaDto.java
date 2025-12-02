package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record FirmaDto(
    Boolean tieneRegistrada,
    String hashFirma,
    LocalDateTime fechaUltimaActualizacion
) {}
