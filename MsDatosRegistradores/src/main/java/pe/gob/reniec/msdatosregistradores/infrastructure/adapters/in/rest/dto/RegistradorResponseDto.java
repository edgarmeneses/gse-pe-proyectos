package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record RegistradorResponseDto(
    Boolean success,
    DataDto data,
    MetadataDto metadata,
    ErrorDto error
) {}
