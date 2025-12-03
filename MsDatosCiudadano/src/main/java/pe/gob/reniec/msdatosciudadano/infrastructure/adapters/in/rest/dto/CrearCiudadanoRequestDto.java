package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;
import java.util.List;

public record CrearCiudadanoRequestDto(
    String solicitudId,
    List<RegistroDto> registros
) {}
