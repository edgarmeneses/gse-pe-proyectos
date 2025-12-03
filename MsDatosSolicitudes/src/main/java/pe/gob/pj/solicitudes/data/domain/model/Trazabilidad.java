package pe.gob.pj.solicitudes.data.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Aggregate Root: Trazabilidad
 * Representa el historial de eventos y cambios de una solicitud
 */
public class Trazabilidad {
    
    // Identificación de la solicitud
    private String solicitudId;
    private String numeroSolicitud;
    private String tipoTramite;
    
    // Estado actual
    private String estadoActual;
    
    // Auditoría
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaModificacion;
    
    // Eventos del historial
    private List<Evento> eventos;

    public Trazabilidad() {
        this.eventos = new ArrayList<>();
    }

    public Trazabilidad(String solicitudId, String numeroSolicitud, String tipoTramite, String estadoActual,
                        LocalDateTime fechaCreacion, LocalDateTime fechaUltimaModificacion, List<Evento> eventos) {
        this.solicitudId = solicitudId;
        this.numeroSolicitud = numeroSolicitud;
        this.tipoTramite = tipoTramite;
        this.estadoActual = estadoActual;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.eventos = eventos != null ? new ArrayList<>(eventos) : new ArrayList<>();
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public List<Evento> getEventos() {
        return Collections.unmodifiableList(eventos);
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos != null ? new ArrayList<>(eventos) : new ArrayList<>();
    }
    
    public void agregarEvento(Evento evento) {
        if (evento != null) {
            this.eventos.add(evento);
            this.fechaUltimaModificacion = LocalDateTime.now();
        }
    }
    
    // Métodos de negocio
    
    public Long getTotalEventos() {
        return (long) eventos.size();
    }
    
    public List<Evento> obtenerEventosPorTipo(String tipoEvento) {
        return eventos.stream()
                .filter(e -> tipoEvento.equalsIgnoreCase(e.getTipoEvento()))
                .toList();
    }
    
    public Evento obtenerUltimoEvento() {
        if (eventos.isEmpty()) {
            return null;
        }
        return eventos.get(eventos.size() - 1);
    }
}
