package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa una alerta
 */
public record AlertaDto(
    String codigo,
    String descripcion,
    String severidad
) {}
