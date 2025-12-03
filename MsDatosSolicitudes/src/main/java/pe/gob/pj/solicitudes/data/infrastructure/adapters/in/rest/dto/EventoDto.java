package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.Map;

public final class EventoDto {
    private final String eventoId;
    private final String tipoEvento;
    private final LocalDateTime fechaHora;
    private final String descripcion;
    private final UsuarioDto usuario;
    private final OficinaDto oficina;
    private final Map<String, Object> detalles;
    private final Map<String, Object> metadatos;
    private final String estadoAnterior;
    private final String estadoNuevo;

    public EventoDto(String eventoId, String tipoEvento, LocalDateTime fechaHora, String descripcion, UsuarioDto usuario, OficinaDto oficina, Map<String, Object> detalles, Map<String, Object> metadatos, String estadoAnterior, String estadoNuevo) {
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

    public String eventoId() { return eventoId; }
    public String tipoEvento() { return tipoEvento; }
    public LocalDateTime fechaHora() { return fechaHora; }
    public String descripcion() { return descripcion; }
    public UsuarioDto usuario() { return usuario; }
    public OficinaDto oficina() { return oficina; }
    public Map<String, Object> detalles() { return detalles; }
    public Map<String, Object> metadatos() { return metadatos; }
    public String estadoAnterior() { return estadoAnterior; }
    public String estadoNuevo() { return estadoNuevo; }
}
