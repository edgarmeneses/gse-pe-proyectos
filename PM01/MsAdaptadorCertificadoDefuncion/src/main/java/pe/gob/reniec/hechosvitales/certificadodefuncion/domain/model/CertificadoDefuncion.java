package pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model;

import java.util.List;

/**
 * Entidad del dominio: Certificado de Defunción
 * Aggregate Root del contexto de Certificados de Defunción
 */
public class CertificadoDefuncion {

    private String nuCdef;
    private String coTipoCdef;
    private String coEstadoCdef;
    private String deEstadoCdef;
    private String feCrea;
    private String feModifica;
    private String observaciones;
    private Fallecido fallecido;
    private Defuncion defuncion;
    private Profesional profesional;
    private Certificante certificante;
    private List<CausaMuerte> causasMuerte;
    private Declarante declarante;
    private Auditoria auditoria;

    public CertificadoDefuncion() {
    }

    public CertificadoDefuncion(String nuCdef, String coTipoCdef, String coEstadoCdef, 
                                String deEstadoCdef, String feCrea, String feModifica, 
                                String observaciones, Fallecido fallecido, Defuncion defuncion, 
                                Profesional profesional, Certificante certificante, 
                                List<CausaMuerte> causasMuerte, Declarante declarante, 
                                Auditoria auditoria) {
        this.nuCdef = nuCdef;
        this.coTipoCdef = coTipoCdef;
        this.coEstadoCdef = coEstadoCdef;
        this.deEstadoCdef = deEstadoCdef;
        this.feCrea = feCrea;
        this.feModifica = feModifica;
        this.observaciones = observaciones;
        this.fallecido = fallecido;
        this.defuncion = defuncion;
        this.profesional = profesional;
        this.certificante = certificante;
        this.causasMuerte = causasMuerte;
        this.declarante = declarante;
        this.auditoria = auditoria;
    }

    public String getNuCdef() {
        return nuCdef;
    }

    public void setNuCdef(String nuCdef) {
        this.nuCdef = nuCdef;
    }

    public String getCoTipoCdef() {
        return coTipoCdef;
    }

    public void setCoTipoCdef(String coTipoCdef) {
        this.coTipoCdef = coTipoCdef;
    }

    public String getCoEstadoCdef() {
        return coEstadoCdef;
    }

    public void setCoEstadoCdef(String coEstadoCdef) {
        this.coEstadoCdef = coEstadoCdef;
    }

    public String getDeEstadoCdef() {
        return deEstadoCdef;
    }

    public void setDeEstadoCdef(String deEstadoCdef) {
        this.deEstadoCdef = deEstadoCdef;
    }

    public String getFeCrea() {
        return feCrea;
    }

    public void setFeCrea(String feCrea) {
        this.feCrea = feCrea;
    }

    public String getFeModifica() {
        return feModifica;
    }

    public void setFeModifica(String feModifica) {
        this.feModifica = feModifica;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Fallecido getFallecido() {
        return fallecido;
    }

    public void setFallecido(Fallecido fallecido) {
        this.fallecido = fallecido;
    }

    public Defuncion getDefuncion() {
        return defuncion;
    }

    public void setDefuncion(Defuncion defuncion) {
        this.defuncion = defuncion;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Certificante getCertificante() {
        return certificante;
    }

    public void setCertificante(Certificante certificante) {
        this.certificante = certificante;
    }

    public List<CausaMuerte> getCausasMuerte() {
        return causasMuerte;
    }

    public void setCausasMuerte(List<CausaMuerte> causasMuerte) {
        this.causasMuerte = causasMuerte;
    }

    public Declarante getDeclarante() {
        return declarante;
    }

    public void setDeclarante(Declarante declarante) {
        this.declarante = declarante;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }
}
