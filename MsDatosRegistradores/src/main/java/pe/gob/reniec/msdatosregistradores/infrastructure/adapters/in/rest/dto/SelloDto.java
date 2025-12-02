package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record SelloDto(
    Boolean tieneRegistrado,
    String hashSello,
    LocalDateTime fechaUltimaActualizacion
) {}
