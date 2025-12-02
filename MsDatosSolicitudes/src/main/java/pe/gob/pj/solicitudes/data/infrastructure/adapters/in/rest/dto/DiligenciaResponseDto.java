package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record DiligenciaResponseDto(
    Long id,
    String numeroDiligencia,
    LocalDateTime fechaDiligencia,
    String tipoDiligencia,
    String estado,
    String descripcion,
    Long solicitudId
) {
}
