package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

public record DireccionResidenciaDto(
    String pais,
    String departamento,
    String provincia,
    String distrito,
    String centroPoblado,
    String barrio,
    String direccion,
    String codigoPostal
) {}
