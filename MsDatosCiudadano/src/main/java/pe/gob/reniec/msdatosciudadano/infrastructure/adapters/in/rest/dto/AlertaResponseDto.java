package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record AlertaResponseDto(
    String id,
    LocalDateTime fechaCreacion,
    String estado
) {}
