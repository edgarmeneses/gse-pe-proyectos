package pe.gob.pj.solicitudes.data.domain.model;

public class DocumentoGenerado {
    
    private String tipoDocumento;
    private String numeroOficio;
    private String urlDocumento;
    private Boolean firmadoDigitalmente;
    private String hash;

    public DocumentoGenerado() {
    }

    public DocumentoGenerado(String tipoDocumento, String numeroOficio, String urlDocumento,
                             Boolean firmadoDigitalmente, String hash) {
        this.tipoDocumento = tipoDocumento;
        this.numeroOficio = numeroOficio;
        this.urlDocumento = urlDocumento;
        this.firmadoDigitalmente = firmadoDigitalmente;
        this.hash = hash;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroOficio() {
        return numeroOficio;
    }

    public void setNumeroOficio(String numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public Boolean getFirmadoDigitalmente() {
        return firmadoDigitalmente;
    }

    public void setFirmadoDigitalmente(Boolean firmadoDigitalmente) {
        this.firmadoDigitalmente = firmadoDigitalmente;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
