package pe.gob.reniec.agendamiento.msdatos.domain.model;

import java.time.LocalDateTime;

/**
 * HistorialCambio - Value Object
 * Representa un cambio registrado en el ciclo de vida de una Cita.
 * Inmutable por diseño para mantener integridad del historial de auditoría.
 */
public class HistorialCambio {
    private final String idHistorial;
    private final LocalDateTime fechaCambio;
    private final String campo;
    private final String valorAnterior;
    private final String valorNuevo;
    private final String motivo;
    private final String usuario;

    public HistorialCambio(String idHistorial, LocalDateTime fechaCambio, String campo,
                           String valorAnterior, String valorNuevo, String motivo, String usuario) {
        this.idHistorial = idHistorial;
        this.fechaCambio = fechaCambio;
        this.campo = campo;
        this.valorAnterior = valorAnterior;
        this.valorNuevo = valorNuevo;
        this.motivo = motivo;
        this.usuario = usuario;
    }

    public String getIdHistorial() {
        return idHistorial;
    }

    public LocalDateTime getFechaCambio() {
        return fechaCambio;
    }

    public String getCampo() {
        return campo;
    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public String getValorNuevo() {
        return valorNuevo;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getUsuario() {
        return usuario;
    }
}
