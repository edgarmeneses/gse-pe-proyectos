package pe.gob.reniec.agendamiento.msdatos.domain.model;

public class Solicitud {
    private String idSolicitud;
    private String numeroTramite;

    public Solicitud() {
    }

    public Solicitud(String idSolicitud, String numeroTramite) {
        this.idSolicitud = idSolicitud;
        this.numeroTramite = numeroTramite;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(String numeroTramite) {
        this.numeroTramite = numeroTramite;
    }
}
