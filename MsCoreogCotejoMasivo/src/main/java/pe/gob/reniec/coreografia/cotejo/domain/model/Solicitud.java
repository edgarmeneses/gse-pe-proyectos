package pe.gob.reniec.coreografia.cotejo.domain.model;

import java.time.LocalDateTime;

public class Solicitud {
    private String numeroSolicitud;
    private String tipoTramite;
    private LocalDateTime fechaSolicitud;
    private String prioridad;

    public Solicitud() {
    }

    public Solicitud(String numeroSolicitud, String tipoTramite, LocalDateTime fechaSolicitud, String prioridad) {
        this.numeroSolicitud = numeroSolicitud;
        this.tipoTramite = tipoTramite;
        this.fechaSolicitud = fechaSolicitud;
        this.prioridad = prioridad;
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

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
