package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

public record ContactoDto(
    String telefonoFijo,
    String telefonoMovil,
    String correoElectronico,
    String correoAlternativo
) {}
