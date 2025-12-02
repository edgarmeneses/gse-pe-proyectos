package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record AprobacionDto(
    Boolean aprobado,
    LocalDateTime fechaAprobacion,
    String usuarioAprobacion,
    String comentarioAprobacion
) {}
