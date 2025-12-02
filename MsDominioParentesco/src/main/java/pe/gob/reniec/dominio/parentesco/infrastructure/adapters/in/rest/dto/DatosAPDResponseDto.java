package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record DatosAPDResponseDto(
    String version,
    LocalDateTime ultimaActualizacion,
    String estadoAPD
) {}
