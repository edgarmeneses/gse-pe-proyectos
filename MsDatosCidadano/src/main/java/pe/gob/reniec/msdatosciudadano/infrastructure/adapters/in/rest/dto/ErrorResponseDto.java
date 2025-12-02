package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ErrorResponseDto(
    String tipo,
    String titulo,
    Integer estado,
    List<ErrorDetalleDto> errores
) {}
