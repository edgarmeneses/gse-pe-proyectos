package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

public record UbicacionDto(
    String codigoDepartamento,
    String nombreDepartamento,
    String codigoProvincia,
    String nombreProvincia,
    String codigoDistrito,
    String nombreDistrito,
    String ubigeo
) {}
