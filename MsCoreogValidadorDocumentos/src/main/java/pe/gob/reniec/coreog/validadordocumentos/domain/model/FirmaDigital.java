package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.time.LocalDateTime;

/**
 * Entidad de dominio que representa una firma digital
 */
public class FirmaDigital {
    private String idFirma;
    private String numeroSerieCertificado;
    private String subjectDN;
    private String algoritmoFirma;
    private LocalDateTime fechaFirma;
    private String huellaCertificado;
    private String entidadCertificadora;

    public FirmaDigital() {
    }

    public FirmaDigital(String idFirma, String numeroSerieCertificado, String subjectDN, 
                        String algoritmoFirma, LocalDateTime fechaFirma, 
                        String huellaCertificado, String entidadCertificadora) {
        this.idFirma = idFirma;
        this.numeroSerieCertificado = numeroSerieCertificado;
        this.subjectDN = subjectDN;
        this.algoritmoFirma = algoritmoFirma;
        this.fechaFirma = fechaFirma;
        this.huellaCertificado = huellaCertificado;
        this.entidadCertificadora = entidadCertificadora;
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
