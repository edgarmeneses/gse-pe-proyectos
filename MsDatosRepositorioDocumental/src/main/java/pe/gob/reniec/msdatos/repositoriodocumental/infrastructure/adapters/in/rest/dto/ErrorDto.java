package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Respuesta de error estándar
 */
public record ErrorDto(
    String tipo,
    String titulo,
    Integer estado,
    List<ErrorDetalleDto> errores
) {}
