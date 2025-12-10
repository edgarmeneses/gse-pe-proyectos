package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

public class ProcesoFirmaDto {
    private String procesoFirmaId;
    private String tramiteId;
    private String estadoFirma;
    private DocumentoDto documentoFirmado;
    private FirmaAplicadaDto firmaAplicada;
    private ValidacionEstadoDto validaciones;
    private AuditoriaDto auditoria;

    public ProcesoFirmaDto() {}

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

    public DocumentoDto getDocumentoFirmado() {
        return documentoFirmado;
    }

    public void setDocumentoFirmado(DocumentoDto documentoFirmado) {
        this.documentoFirmado = documentoFirmado;
    }

    public FirmaAplicadaDto getFirmaAplicada() {
        return firmaAplicada;
    }

    public void setFirmaAplicada(FirmaAplicadaDto firmaAplicada) {
        this.firmaAplicada = firmaAplicada;
    }

    public ValidacionEstadoDto getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(ValidacionEstadoDto validaciones) {
        this.validaciones = validaciones;
    }

    public AuditoriaDto getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaDto auditoria) {
        this.auditoria = auditoria;
    }
}
