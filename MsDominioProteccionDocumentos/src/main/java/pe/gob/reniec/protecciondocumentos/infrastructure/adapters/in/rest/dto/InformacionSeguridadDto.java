package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record InformacionSeguridadDto(
    String passwordHashSHA512,
    String algoritmoUtilizado,
    Integer longitudPassword,
    LocalDateTime fechaGeneracion,
    LocalDateTime fechaExpiracion
) {}
