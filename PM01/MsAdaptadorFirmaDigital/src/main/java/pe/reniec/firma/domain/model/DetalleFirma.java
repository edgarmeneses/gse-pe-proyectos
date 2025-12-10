package pe.reniec.firma.domain.model;

public class DetalleFirma {
    private Integer numeroFirma;
    private Firmante firmante;
    private Certificado certificado;
    private ValidacionEstado validaciones;
    private Timestamp timestamp;
    private DetallesValidacion detallesValidacion;

    public DetalleFirma() {}

    public Integer getNumeroFirma() {
        return numeroFirma;
    }

    public void setNumeroFirma(Integer numeroFirma) {
        this.numeroFirma = numeroFirma;
    }

    public Firmante getFirmante() {
        return firmante;
    }

    public void setFirmante(Firmante firmante) {
        this.firmante = firmante;
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public ValidacionEstado getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(ValidacionEstado validaciones) {
        this.validaciones = validaciones;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public DetallesValidacion getDetallesValidacion() {
        return detallesValidacion;
    }

    public void setDetallesValidacion(DetallesValidacion detallesValidacion) {
        this.detallesValidacion = detallesValidacion;
    }
}
