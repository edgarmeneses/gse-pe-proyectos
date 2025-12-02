package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ErrorDto(
    String tipo,
    String titulo,
    Integer estado,
    List<ErrorDetalleDto> errores
) {}
