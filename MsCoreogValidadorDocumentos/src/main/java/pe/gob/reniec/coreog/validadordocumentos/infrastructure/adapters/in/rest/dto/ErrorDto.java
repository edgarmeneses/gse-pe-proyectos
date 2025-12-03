package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO record que representa un error
 */
public record ErrorDto(
    String tipo,
    String titulo,
    Integer estado,
    List<DetalleErrorDto> errores
) {}
