package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Record para respuesta de error
 */
public record ErrorResponseDto(
    String tipo,
    String titulo,
    Integer estado,
    List<DetalleErrorDto> errores
) {}
