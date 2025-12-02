package pe.gob.reniec.certificadosdigitales.domain.model;

import java.time.LocalDateTime;

public class Metadatos {
    private String oficinaOrigen;
    private String usuarioRegistrador;
    private String ipOrigen;
    private LocalDateTime timestampSolicitud;

    public Metadatos() {
    }

    public Metadatos(String oficinaOrigen, String usuarioRegistrador, String ipOrigen, LocalDateTime timestampSolicitud) {
        this.oficinaOrigen = oficinaOrigen;
        this.usuarioRegistrador = usuarioRegistrador;
        this.ipOrigen = ipOrigen;
        this.timestampSolicitud = timestampSolicitud;
    }

    public String getOficinaOrigen() {
        return oficinaOrigen;
    }

    public void setOficinaOrigen(String oficinaOrigen) {
        this.oficinaOrigen = oficinaOrigen;
    }

    public String getUsuarioRegistrador() {
        return usuarioRegistrador;
    }

    public void setUsuarioRegistrador(String usuarioRegistrador) {
        this.usuarioRegistrador = usuarioRegistrador;
    }

    public String getIpOrigen() {
        return ipOrigen;
    }

    public void setIpOrigen(String ipOrigen) {
        this.ipOrigen = ipOrigen;
    }

    public LocalDateTime getTimestampSolicitud() {
        return timestampSolicitud;
    }

    public void setTimestampSolicitud(LocalDateTime timestampSolicitud) {
        this.timestampSolicitud = timestampSolicitud;
    }
}
