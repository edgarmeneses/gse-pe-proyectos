package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;

public record ActualizarCiudadanoRequestDto(
    String estado,
    String tipoDocumento,
    String numeroDocumento,
    String primerNombre,
    String segundoNombre,
    String primerApellido,
    String segundoApellido,
    LocalDate fechaNacimiento,
    String sexo,
    String estadoCivil,
    String nacionalidad,
    String paisNacimiento,
    String departamentoNacimiento,
    String provinciaNacimiento,
    String distritoNacimiento,
    String grupoSanguineo,
    String estatura,
    InformacionParentalDto informacionParental,
    DireccionResidenciaDto direccionResidencia,
    ContactoDto contacto,
    InformacionElectoralDto informacionElectoral,
    DatosBiometricosDto datosBiometricos
) {}
