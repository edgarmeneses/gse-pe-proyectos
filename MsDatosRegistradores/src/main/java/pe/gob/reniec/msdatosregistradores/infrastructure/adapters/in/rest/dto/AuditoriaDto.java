package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record AuditoriaDto(
    String usuarioCreacion,
    LocalDateTime fechaCreacion,
    String usuarioModificacion,
    LocalDateTime fechaModificacion
) {}
