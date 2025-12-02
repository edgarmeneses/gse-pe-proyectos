package pe.gob.reniec.certificadosdigitales.domain.model;

import java.time.LocalDateTime;

public class Certificado {
    private String tipoCertificado;
    private String certificadoId;
    private String numeroSerie;
    private LocalDateTime fechaEmision;
    private LocalDateTime fechaVencimiento;
    private Long vigenciaAnios;
    private String estadoCertificado;
    private String algoritmoFirma;
    private Long longitudClave;
    private String subjectDN;
    private String huellaCertificado;
    private String certificadoBase64;

    public Certificado() {
    }

    public Certificado(String tipoCertificado, String certificadoId, String numeroSerie,
                       LocalDateTime fechaEmision, LocalDateTime fechaVencimiento, Long vigenciaAnios,
                       String estadoCertificado, String algoritmoFirma, Long longitudClave,
                       String subjectDN, String huellaCertificado, String certificadoBase64) {
        this.tipoCertificado = tipoCertificado;
        this.certificadoId = certificadoId;
        this.numeroSerie = numeroSerie;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.vigenciaAnios = vigenciaAnios;
        this.estadoCertificado = estadoCertificado;
        this.algoritmoFirma = algoritmoFirma;
        this.longitudClave = longitudClave;
        this.subjectDN = subjectDN;
        this.huellaCertificado = huellaCertificado;
        this.certificadoBase64 = certificadoBase64;
    }

    public String getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(String tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public String getCertificadoId() {
        return certificadoId;
    }

    public void setCertificadoId(String certificadoId) {
        this.certificadoId = certificadoId;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getVigenciaAnios() {
        return vigenciaAnios;
    }

    public void setVigenciaAnios(Long vigenciaAnios) {
        this.vigenciaAnios = vigenciaAnios;
    }

    public String getEstadoCertificado() {
        return estadoCertificado;
    }

    public void setEstadoCertificado(String estadoCertificado) {
        this.estadoCertificado = estadoCertificado;
    }

    public String getAlgoritmoFirma() {
        return algoritmoFirma;
    }

    public void setAlgoritmoFirma(String algoritmoFirma) {
        this.algoritmoFirma = algoritmoFirma;
    }

    public Long getLongitudClave() {
        return longitudClave;
    }

    public void setLongitudClave(Long longitudClave) {
        this.longitudClave = longitudClave;
    }

    public String getSubjectDN() {
        return subjectDN;
    }

    public void setSubjectDN(String subjectDN) {
        this.subjectDN = subjectDN;
    }

    public String getHuellaCertificado() {
        return huellaCertificado;
    }

    public void setHuellaCertificado(String huellaCertificado) {
        this.huellaCertificado = huellaCertificado;
    }

    public String getCertificadoBase64() {
        return certificadoBase64;
    }

    public void setCertificadoBase64(String certificadoBase64) {
        this.certificadoBase64 = certificadoBase64;
    }
}
