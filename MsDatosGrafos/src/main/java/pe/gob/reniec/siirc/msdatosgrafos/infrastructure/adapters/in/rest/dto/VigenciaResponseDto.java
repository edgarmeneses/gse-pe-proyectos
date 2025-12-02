package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

/**
 * DTO Record para respuesta de vigencia
 */
public record VigenciaResponseDto(
    String fechaInicio,
    String fechaFin,
    Boolean esVigente
) {}
