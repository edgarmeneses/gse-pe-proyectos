package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

/**
 * DTO Record para respuesta de tipo de parentesco
 */
public record TipoParentescoResponseDto(
    String codigo,
    String descripcion,
    Boolean esSimetrico
) {}
