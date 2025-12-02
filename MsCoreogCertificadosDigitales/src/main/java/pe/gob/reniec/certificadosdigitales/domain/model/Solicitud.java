package pe.gob.reniec.certificadosdigitales.domain.model;

public class Solicitud {
    private String numeroDocumento;
    private String tipoDocumento;
    private String codigoSolicitudTramite;
    private String numeroTramite;

    public Solicitud() {
    }

    public Solicitud(String numeroDocumento, String tipoDocumento, String codigoSolicitudTramite, String numeroTramite) {
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.codigoSolicitudTramite = codigoSolicitudTramite;
        this.numeroTramite = numeroTramite;
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
