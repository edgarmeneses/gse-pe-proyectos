package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO para errores en la respuesta.
 */
public record ErrorResponseDto(
    ErrorDto error
) {}

record ErrorDto(
    String tipo,
    String titulo,
    Integer estado,
    List<DetalleErrorDto> errores
) {}

record DetalleErrorDto(
    String detalleError
) {}
