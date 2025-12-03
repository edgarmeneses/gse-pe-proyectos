package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record TrazabilidadResponseDto(
        String solicitudId,
        String numeroSolicitud,
        String tipoTramite,
        String estadoActual,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaUltimaModificacion,
        Long totalEventos,
        List<EventoDto> eventos,
        ResumenEventosDto resumenEventos,
        EstadisticasDto estadisticas,
        PaginacionDto paginacion
) {
}
