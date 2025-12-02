package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa el detalle de un error
 */
public record DetalleErrorDto(
    String codigo,
    String campo,
    String detalleError
) {}
