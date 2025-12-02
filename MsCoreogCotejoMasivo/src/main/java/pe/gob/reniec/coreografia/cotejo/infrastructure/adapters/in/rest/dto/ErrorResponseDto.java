package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ErrorResponseDto(
    String tipo,
    String titulo,
    Integer estado,
    List<DetalleErrorDto> errores
) {}
