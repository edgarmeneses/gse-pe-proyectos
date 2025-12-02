package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record InformacionPublicacionDto(
    LocalDateTime fechaPublicacion,
    String lugarPublicacion,
    String observaciones
) {}
