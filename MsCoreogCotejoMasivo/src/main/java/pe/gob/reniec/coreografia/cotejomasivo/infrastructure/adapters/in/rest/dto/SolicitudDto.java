package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO - Solicitud
 */
public class SolicitudDto {
    
    private String numeroSolicitud;
    private String tipoTramite;
    private String fechaSolicitud;
    private String prioridad;
    
    public SolicitudDto() {
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
    
    public String getFechaSolicitud() {
        return fechaSolicitud;
    }
    
    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    
    public String getPrioridad() {
        return prioridad;
    }
    
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
