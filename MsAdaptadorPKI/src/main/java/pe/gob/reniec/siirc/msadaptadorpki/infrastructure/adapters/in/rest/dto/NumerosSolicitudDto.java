package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto;

public class NumerosSolicitudDto {
    private String numeroSolicitudAutenticacion;
    private String numeroSolicitudFirma;
    private String numeroSolicitudCifrado;

    public NumerosSolicitudDto() {
    }

    public String getNumeroSolicitudAutenticacion() {
        return numeroSolicitudAutenticacion;
    }

    public void setNumeroSolicitudAutenticacion(String numeroSolicitudAutenticacion) {
        this.numeroSolicitudAutenticacion = numeroSolicitudAutenticacion;
    }

    public String getNumeroSolicitudFirma() {
        return numeroSolicitudFirma;
    }

    public void setNumeroSolicitudFirma(String numeroSolicitudFirma) {
        this.numeroSolicitudFirma = numeroSolicitudFirma;
    }

    public String getNumeroSolicitudCifrado() {
        return numeroSolicitudCifrado;
    }

    public void setNumeroSolicitudCifrado(String numeroSolicitudCifrado) {
        this.numeroSolicitudCifrado = numeroSolicitudCifrado;
    }
}
