package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record ConfirmacionDto(
    Boolean confirmado,
    LocalDateTime fechaConfirmacion,
    String usuarioConfirmacion,
    String comentarioConfirmacion
) {}
