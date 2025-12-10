package pe.reniec.firma.domain.model;

public class ValidacionConfig {
    private Boolean verificarCertificado;
    private Boolean verificarRevocacion;
    private Boolean verificarCadenaConfianza;
    private Boolean verificarTimestamp;
    private Boolean verificarIntegridad;

    public ValidacionConfig() {}

    public Boolean getVerificarCertificado() {
        return verificarCertificado;
    }

    public void setVerificarCertificado(Boolean verificarCertificado) {
        this.verificarCertificado = verificarCertificado;
    }

    public Boolean getVerificarRevocacion() {
        return verificarRevocacion;
    }

    public void setVerificarRevocacion(Boolean verificarRevocacion) {
        this.verificarRevocacion = verificarRevocacion;
    }

    public Boolean getVerificarCadenaConfianza() {
        return verificarCadenaConfianza;
    }

    public void setVerificarCadenaConfianza(Boolean verificarCadenaConfianza) {
        this.verificarCadenaConfianza = verificarCadenaConfianza;
    }

    public Boolean getVerificarTimestamp() {
        return verificarTimestamp;
    }

    public void setVerificarTimestamp(Boolean verificarTimestamp) {
        this.verificarTimestamp = verificarTimestamp;
    }

    public Boolean getVerificarIntegridad() {
        return verificarIntegridad;
    }

    public void setVerificarIntegridad(Boolean verificarIntegridad) {
        this.verificarIntegridad = verificarIntegridad;
    }
}
