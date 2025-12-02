package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;

public record CiudadanoAnalizadoResponseDto(
    String idCiudadano,
    String nombreCompleto,
    LocalDate fechaNacimiento,
    String estadoCivil,
    DatosAPDResponseDto datosAPD
) {}
