package pe.gob.reniec.gse.agendamiento.data.domain.model;

public class Solicitud {
    
    private final String idSolicitud;
    private final String numeroTramite;
    
    public Solicitud(String idSolicitud, String numeroTramite) {
        if (idSolicitud == null || idSolicitud.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de solicitud es requerido");
        }
        if (numeroTramite == null || numeroTramite.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de trámite es requerido");
        }
        this.idSolicitud = idSolicitud.trim();
        this.numeroTramite = numeroTramite.trim();
    }
    
    public String getIdSolicitud() {
        return idSolicitud;
    }
    
    public String getNumeroTramite() {
        return numeroTramite;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitud solicitud = (Solicitud) o;
        return idSolicitud.equals(solicitud.idSolicitud);
    }
    
    @Override
    public int hashCode() {
        return idSolicitud.hashCode();
    }
}
