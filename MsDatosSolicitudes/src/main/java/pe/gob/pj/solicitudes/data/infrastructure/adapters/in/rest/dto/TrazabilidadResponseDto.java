package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record TrazabilidadResponseDto(
    Long id,
    Long solicitudId,
    LocalDateTime fecha,
    String accion,
    String usuario,
    String detalle
) {
}
