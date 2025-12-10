package pe.reniec.firma.domain.model;

public class ValidacionEstado {
    private Boolean certificadoValido;
    private Boolean certificadoNoRevocado;
    private Boolean firmaValida;
    private Boolean certificadoVigente;
    private Boolean cadenaConfianzaVerificada;
    private Boolean timestampValido;
    private Boolean integridadDocumento;

    public ValidacionEstado() {}

    public Boolean getCertificadoValido() {
        return certificadoValido;
    }

    public void setCertificadoValido(Boolean certificadoValido) {
        this.certificadoValido = certificadoValido;
    }

    public Boolean getCertificadoNoRevocado() {
        return certificadoNoRevocado;
    }

    public void setCertificadoNoRevocado(Boolean certificadoNoRevocado) {
        this.certificadoNoRevocado = certificadoNoRevocado;
    }

    public Boolean getFirmaValida() {
        return firmaValida;
    }

    public void setFirmaValida(Boolean firmaValida) {
        this.firmaValida = firmaValida;
    }

    public Boolean getCertificadoVigente() {
        return certificadoVigente;
    }

    public void setCertificadoVigente(Boolean certificadoVigente) {
        this.certificadoVigente = certificadoVigente;
    }

    public Boolean getCadenaConfianzaVerificada() {
        return cadenaConfianzaVerificada;
    }

    public void setCadenaConfianzaVerificada(Boolean cadenaConfianzaVerificada) {
        this.cadenaConfianzaVerificada = cadenaConfianzaVerificada;
    }

    public Boolean getTimestampValido() {
        return timestampValido;
    }

    public void setTimestampValido(Boolean timestampValido) {
        this.timestampValido = timestampValido;
    }

    public Boolean getIntegridadDocumento() {
        return integridadDocumento;
    }

    public void setIntegridadDocumento(Boolean integridadDocumento) {
        this.integridadDocumento = integridadDocumento;
    }
}
