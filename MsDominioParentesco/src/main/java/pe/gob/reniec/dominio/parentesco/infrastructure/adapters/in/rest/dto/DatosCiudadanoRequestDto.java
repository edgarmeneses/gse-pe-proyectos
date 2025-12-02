package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;

public record DatosCiudadanoRequestDto(
    String nombres,
    String apellidoPaterno,
    String apellidoMaterno,
    LocalDate fechaNacimiento,
    String sexo,
    String estadoCivil
) {}
