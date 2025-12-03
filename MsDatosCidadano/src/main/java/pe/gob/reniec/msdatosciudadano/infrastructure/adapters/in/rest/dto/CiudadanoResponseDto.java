package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record CiudadanoResponseDto(
    String id,
    LocalDateTime fechaCreacion
) {}
