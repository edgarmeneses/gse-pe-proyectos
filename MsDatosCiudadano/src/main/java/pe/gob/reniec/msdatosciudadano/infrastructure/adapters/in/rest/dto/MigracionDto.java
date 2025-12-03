package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record MigracionDto (
    String tipoDocumento,
    String numeroDocumento,
    String nombreCompleto,
    DomicilioDto domicilio,
    LocalDateTime fechaCambio
){
}
