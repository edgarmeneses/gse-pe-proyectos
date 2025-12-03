package pe.gob.pj.solicitudes.data.domain.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Evento {
    
    private String eventoId;
    private String tipoEvento;
    private LocalDateTime fechaHora;
    private String descripcion;
    private Usuario usuario;
    private Oficina oficina;
    private Map<String, Object> detalles;
    private Map<String, Object> metadatos;
    private String estadoAnterior;
    private String estadoNuevo;

    public Evento() {
    }

    public Evento(String eventoId, String tipoEvento, LocalDateTime fechaHora, String descripcion,
                  Usuario usuario, Oficina oficina, Map<String, Object> detalles, Map<String, Object> metadatos,
                  String estadoAnterior, String estadoNuevo) {
        this.eventoId = eventoId;
        this.tipoEvento = tipoEvento;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.oficina = oficina;
        this.detalles = detalles;
        this.metadatos = metadatos;
        this.estadoAnterior = estadoAnterior;
        this.estadoNuevo = estadoNuevo;
    }

    public String getEventoId() {
        return eventoId;
    }

    public void setEventoId(String eventoId) {
        this.eventoId = eventoId;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public Map<String, Object> getDetalles() {
        return detalles;
    }

    public void setDetalles(Map<String, Object> detalles) {
        this.detalles = detalles;
    }

    public Map<String, Object> getMetadatos() {
        return metadatos;
    }

    public void setMetadatos(Map<String, Object> metadatos) {
        this.metadatos = metadatos;
    }

    public String getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public String getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(String estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }
}
