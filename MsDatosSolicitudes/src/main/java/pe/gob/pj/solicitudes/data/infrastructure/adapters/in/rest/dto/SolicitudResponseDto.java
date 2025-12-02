package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record SolicitudResponseDto(
    Long id,
    String numeroSolicitud,
    LocalDateTime fechaSolicitud,
    String tipoSolicitud,
    String estado,
    String solicitante,
    String descripcion,
    List<DiligenciaResponseDto> diligencias
) {
}
