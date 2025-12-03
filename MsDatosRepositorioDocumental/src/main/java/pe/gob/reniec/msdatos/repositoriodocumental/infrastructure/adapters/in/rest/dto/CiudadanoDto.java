package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Información de ciudadano
 */
public record CiudadanoDto(
    String dni,
    String nombreCompleto
) {}
