package pe.gob.sunat.gse.coreog.certificadosdigitales.domain.model;

/**
 * Aggregate Root: CertificadoDigital
 * Representa un certificado digital DNIe emitido
 */
public class CertificadoDigital {
    
    private String tipoCertificado;
    private String certificadoId;
    private String numeroSerie;
    private String fechaEmision;
    private String fechaVencimiento;
    private Integer vigenciaAnios;
    private String estadoCertificado;
    private String algoritmoFirma;
    private Integer longitudClave;
    private String subjectDN;
    private String huellaCertificado;
    private String certificadoBase64;
    
    public CertificadoDigital() {
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
    
    public String getFechaEmision() {
        return fechaEmision;
    }
    
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public Integer getVigenciaAnios() {
        return vigenciaAnios;
    }
    
    public void setVigenciaAnios(Integer vigenciaAnios) {
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
    
    public Integer getLongitudClave() {
        return longitudClave;
    }
    
    public void setLongitudClave(Integer longitudClave) {
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
