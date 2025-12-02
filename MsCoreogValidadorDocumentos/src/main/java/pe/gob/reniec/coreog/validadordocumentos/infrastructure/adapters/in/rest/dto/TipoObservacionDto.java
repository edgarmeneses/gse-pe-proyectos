package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa un tipo de observación
 */
public record TipoObservacionDto(
    String codigo,
    String descripcion
) {}
