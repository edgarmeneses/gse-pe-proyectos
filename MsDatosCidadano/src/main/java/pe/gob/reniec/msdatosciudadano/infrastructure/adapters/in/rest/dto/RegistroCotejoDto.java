package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;

public record RegistroCotejoDto(
    String numeroSecuencia,
    String tipoDocumento,
    String numeroDocumento,
    String primerApellido,
    String segundoApellido,
    String prenombres,
    LocalDate fechaNacimiento,
    String sexo,
    String estadoCivil,
    String ubigeo,
    String direccion
) {}
