package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

public record RegistradorDetalleResponseDto(
    Boolean success,
    DetalleDataDto data,
    MetadataDto metadata,
    ErrorDto error
) {}
