package pe.reniec.firma.domain.model;

public class ProcesoFirma {
    private String procesoFirmaId;
    private String tramiteId;
    private String estadoFirma;
    private Documento documentoFirmado;
    private FirmaAplicada firmaAplicada;
    private ValidacionEstado validaciones;
    private Auditoria auditoria;

    public ProcesoFirma() {}

    public String getProcesoFirmaId() {
        return procesoFirmaId;
    }

    public void setProcesoFirmaId(String procesoFirmaId) {
        this.procesoFirmaId = procesoFirmaId;
    }

    public String getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
    }

    public String getEstadoFirma() {
        return estadoFirma;
    }

    public void setEstadoFirma(String estadoFirma) {
        this.estadoFirma = estadoFirma;
    }

    public Documento getDocumentoFirmado() {
        return documentoFirmado;
    }

    public void setDocumentoFirmado(Documento documentoFirmado) {
        this.documentoFirmado = documentoFirmado;
    }

    public FirmaAplicada getFirmaAplicada() {
        return firmaAplicada;
    }

    public void setFirmaAplicada(FirmaAplicada firmaAplicada) {
        this.firmaAplicada = firmaAplicada;
    }

    public ValidacionEstado getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(ValidacionEstado validaciones) {
        this.validaciones = validaciones;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }
}
