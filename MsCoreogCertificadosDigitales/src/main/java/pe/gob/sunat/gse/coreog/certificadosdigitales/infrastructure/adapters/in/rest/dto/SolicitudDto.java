package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO para información de la solicitud
 */
public class SolicitudDto {
    
    private String numeroDocumento;
    private String tipoDocumento;
    private String codigoSolicitudTramite;
    private String numeroTramite;
    
    public SolicitudDto() {
    }
    
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    public String getCodigoSolicitudTramite() {
        return codigoSolicitudTramite;
    }
    
    public void setCodigoSolicitudTramite(String codigoSolicitudTramite) {
        this.codigoSolicitudTramite = codigoSolicitudTramite;
    }
    
    public String getNumeroTramite() {
        return numeroTramite;
    }
    
    public void setNumeroTramite(String numeroTramite) {
        this.numeroTramite = numeroTramite;
    }
}
