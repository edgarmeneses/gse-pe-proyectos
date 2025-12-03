package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record CiudadanoPorDocumentoResponse(
    String tipoDocumento,
    String numeroDocumento,
    LocalDateTime fechaCreacion,
    LocalDateTime fechaActualizacion,
    Object ciudadano,
    String estado
) {
}
