package pe.gob.reniec.protecciondocumentos.domain.model;

import java.time.LocalDateTime;

public class MetadatosSolicitud {
    private String tipoTramite;
    private String numeroSolicitud;
    private String dniSolicitante;
    private LocalDateTime fechaGeneracion;

    public MetadatosSolicitud() {
    }

    public MetadatosSolicitud(String tipoTramite, String numeroSolicitud, String dniSolicitante, LocalDateTime fechaGeneracion) {
        this.tipoTramite = tipoTramite;
        this.numeroSolicitud = numeroSolicitud;
        this.dniSolicitante = dniSolicitante;
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getDniSolicitante() {
        return dniSolicitante;
    }

    public void setDniSolicitante(String dniSolicitante) {
        this.dniSolicitante = dniSolicitante;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }
}
