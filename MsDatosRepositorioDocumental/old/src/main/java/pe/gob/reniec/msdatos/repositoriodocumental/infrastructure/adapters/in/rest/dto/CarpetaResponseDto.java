package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record CarpetaResponseDto(
    String id,
    LocalDateTime createdAt,
    String estadoCarpeta,
    String ruta
) {}
