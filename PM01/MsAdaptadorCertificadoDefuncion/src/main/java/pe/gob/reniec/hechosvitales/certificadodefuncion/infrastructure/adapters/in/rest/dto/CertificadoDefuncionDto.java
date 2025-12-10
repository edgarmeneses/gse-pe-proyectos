package pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Certificado de Defunción para respuestas REST
 */
public class CertificadoDefuncionDto {

    private String nuCdef;
    private String coTipoCdef;
    private String coEstadoCdef;
    private String deEstadoCdef;
    private String feCrea;
    private String feModifica;
    private String observaciones;
    private FallecidoDto fallecido;
    private DefuncionDto defuncion;
    private ProfesionalDto profesional;
    private CertificanteDto certificante;
    private List<CausaMuerteDto> causasMuerte;
    private DeclaranteDto declarante;
    private AuditoriaDto auditoria;

    public CertificadoDefuncionDto() {
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

    public FallecidoDto getFallecido() {
        return fallecido;
    }

    public void setFallecido(FallecidoDto fallecido) {
        this.fallecido = fallecido;
    }

    public DefuncionDto getDefuncion() {
        return defuncion;
    }

    public void setDefuncion(DefuncionDto defuncion) {
        this.defuncion = defuncion;
    }

    public ProfesionalDto getProfesional() {
        return profesional;
    }

    public void setProfesional(ProfesionalDto profesional) {
        this.profesional = profesional;
    }

    public CertificanteDto getCertificante() {
        return certificante;
    }

    public void setCertificante(CertificanteDto certificante) {
        this.certificante = certificante;
    }

    public List<CausaMuerteDto> getCausasMuerte() {
        return causasMuerte;
    }

    public void setCausasMuerte(List<CausaMuerteDto> causasMuerte) {
        this.causasMuerte = causasMuerte;
    }

    public DeclaranteDto getDeclarante() {
        return declarante;
    }

    public void setDeclarante(DeclaranteDto declarante) {
        this.declarante = declarante;
    }

    public AuditoriaDto getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaDto auditoria) {
        this.auditoria = auditoria;
    }
}
