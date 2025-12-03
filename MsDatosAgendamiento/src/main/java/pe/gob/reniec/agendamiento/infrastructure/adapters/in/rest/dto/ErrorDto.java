package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ErrorDto(
    String tipo,
    String titulo,
    Integer estado,
    List<DetalleErrorDto> errores
) {}
