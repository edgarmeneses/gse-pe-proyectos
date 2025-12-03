package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO para metadatos de la solicitud
 */
public class MetadatosDto {
    
    private String oficinaOrigen;
    private String usuarioRegistrador;
    private String ipOrigen;
    private String timestampSolicitud;
    
    public MetadatosDto() {
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
    
    public String getTimestampSolicitud() {
        return timestampSolicitud;
    }
    
    public void setTimestampSolicitud(String timestampSolicitud) {
        this.timestampSolicitud = timestampSolicitud;
    }
}
