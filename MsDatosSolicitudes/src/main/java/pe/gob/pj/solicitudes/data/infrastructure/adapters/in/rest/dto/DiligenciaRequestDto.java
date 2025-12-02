package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record DiligenciaRequestDto(
    String numeroDiligencia,
    LocalDateTime fechaDiligencia,
    String tipoDiligencia,
    String estado,
    String descripcion
) {
}
