package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;

public record CiudadanoDto (
    String id,
    String tipoDocumento,
    String numeroDocumento,
    String nombreCompleto,
    String primerApellido,
    String segundoApellido,
    String prenombres,
    LocalDate fechaNacimiento,
    String numeroInscripcion
){
}
