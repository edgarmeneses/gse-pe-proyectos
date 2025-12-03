package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;

public record RegistroDto(
    String numeroSecuencia,
    String tipoDocumento,
    String numeroDocumento
) {}
