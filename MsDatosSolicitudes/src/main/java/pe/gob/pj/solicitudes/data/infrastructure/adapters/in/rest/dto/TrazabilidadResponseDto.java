package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public final class TrazabilidadResponseDto {
    private final String solicitudId;
    private final String numeroSolicitud;
    private final String tipoTramite;
    private final String estadoActual;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaUltimaModificacion;
    private final Long totalEventos;
    private final List<EventoDto> eventos;
    private final ResumenEventosDto resumenEventos;
    private final EstadisticasDto estadisticas;
    private final PaginacionDto paginacion;

    public TrazabilidadResponseDto(String solicitudId, String numeroSolicitud, String tipoTramite, String estadoActual, LocalDateTime fechaCreacion, LocalDateTime fechaUltimaModificacion, Long totalEventos, List<EventoDto> eventos, ResumenEventosDto resumenEventos, EstadisticasDto estadisticas, PaginacionDto paginacion) {
        this.solicitudId = solicitudId;
        this.numeroSolicitud = numeroSolicitud;
        this.tipoTramite = tipoTramite;
        this.estadoActual = estadoActual;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.totalEventos = totalEventos;
        this.eventos = eventos;
        this.resumenEventos = resumenEventos;
        this.estadisticas = estadisticas;
        this.paginacion = paginacion;
    }

    public String solicitudId() { return solicitudId; }
    public String numeroSolicitud() { return numeroSolicitud; }
    public String tipoTramite() { return tipoTramite; }
    public String estadoActual() { return estadoActual; }
    public LocalDateTime fechaCreacion() { return fechaCreacion; }
    public LocalDateTime fechaUltimaModificacion() { return fechaUltimaModificacion; }
    public Long totalEventos() { return totalEventos; }
    public List<EventoDto> eventos() { return eventos; }
    public ResumenEventosDto resumenEventos() { return resumenEventos; }
    public EstadisticasDto estadisticas() { return estadisticas; }
    public PaginacionDto paginacion() { return paginacion; }
}
