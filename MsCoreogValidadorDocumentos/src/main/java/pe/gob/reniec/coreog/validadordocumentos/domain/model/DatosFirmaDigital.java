package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.time.LocalDateTime;

/**
 * Objeto de valor que representa los datos de la firma digital analizada
 */
public class DatosFirmaDigital {
    private String idFirma;
    private String numeroSerieCertificado;
    private String subjectDN;
    private String algoritmoFirma;
    private LocalDateTime fechaFirma;
    private String huellaCertificado;
    private String entidadCertificadora;

    public DatosFirmaDigital() {
    }

    public String getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(String idFirma) {
        this.idFirma = idFirma;
    }

    public String getNumeroSerieCertificado() {
        return numeroSerieCertificado;
    }

    public void setNumeroSerieCertificado(String numeroSerieCertificado) {
        this.numeroSerieCertificado = numeroSerieCertificado;
    }

    public String getSubjectDN() {
        return subjectDN;
    }

    public void setSubjectDN(String subjectDN) {
        this.subjectDN = subjectDN;
    }

    public String getAlgoritmoFirma() {
        return algoritmoFirma;
    }

    public void setAlgoritmoFirma(String algoritmoFirma) {
        this.algoritmoFirma = algoritmoFirma;
    }

    public LocalDateTime getFechaFirma() {
        return fechaFirma;
    }

    public void setFechaFirma(LocalDateTime fechaFirma) {
        this.fechaFirma = fechaFirma;
    }

    public String getHuellaCertificado() {
        return huellaCertificado;
    }

    public void setHuellaCertificado(String huellaCertificado) {
        this.huellaCertificado = huellaCertificado;
    }

    public String getEntidadCertificadora() {
        return entidadCertificadora;
    }

    public void setEntidadCertificadora(String entidadCertificadora) {
        this.entidadCertificadora = entidadCertificadora;
    }
}
