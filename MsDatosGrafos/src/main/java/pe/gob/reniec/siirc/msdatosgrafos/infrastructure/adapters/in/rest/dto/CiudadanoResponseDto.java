package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

/**
 * DTO Record para respuesta de ciudadano
 */
public record CiudadanoResponseDto(
    String idCiudadano,
    String nombre,
    String fechaNacimiento
) {}
