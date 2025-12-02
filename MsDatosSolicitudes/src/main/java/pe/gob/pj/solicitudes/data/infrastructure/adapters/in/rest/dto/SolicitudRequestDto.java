package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record SolicitudRequestDto(
    String numeroSolicitud,
    LocalDateTime fechaSolicitud,
    String tipoSolicitud,
    String estado,
    String solicitante,
    String descripcion,
    List<DiligenciaRequestDto> diligencias
) {
}
