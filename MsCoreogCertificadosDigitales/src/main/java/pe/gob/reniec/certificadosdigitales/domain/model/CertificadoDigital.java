package pe.gob.reniec.certificadosdigitales.domain.model;

import java.util.List;

public class CertificadoDigital {
    private Transaccion transaccion;
    private Ciudadano ciudadano;
    private List<Certificado> certificados;
    private PasosProceso pasosProceso;
    private Auditoria auditoria;

    public CertificadoDigital() {
    }

    public CertificadoDigital(Transaccion transaccion, Ciudadano ciudadano, List<Certificado> certificados,
                              PasosProceso pasosProceso, Auditoria auditoria) {
        this.transaccion = transaccion;
        this.ciudadano = ciudadano;
        this.certificados = certificados;
        this.pasosProceso = pasosProceso;
        this.auditoria = auditoria;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public List<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    public PasosProceso getPasosProceso() {
        return pasosProceso;
    }

    public void setPasosProceso(PasosProceso pasosProceso) {
        this.pasosProceso = pasosProceso;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }
}
