package pe.reniec.firma.domain.model;

import java.util.List;

public class ProcesoLote {
    private String loteId;
    private String procesoLoteId;
    private String estadoLote;
    private Integer totalDocumentos;
    private Integer documentosFirmados;
    private Integer documentosFallidos;
    private List<DocumentoLote> resultadosDocumentos;
    private Firmante firmante;
    private Auditoria auditoria;
    private Metadata metadata;

    public ProcesoLote() {}

    public String getLoteId() {
        return loteId;
    }

    public void setLoteId(String loteId) {
        this.loteId = loteId;
    }

    public String getProcesoLoteId() {
        return procesoLoteId;
    }

    public void setProcesoLoteId(String procesoLoteId) {
        this.procesoLoteId = procesoLoteId;
    }

    public String getEstadoLote() {
        return estadoLote;
    }

    public void setEstadoLote(String estadoLote) {
        this.estadoLote = estadoLote;
    }

    public Integer getTotalDocumentos() {
        return totalDocumentos;
    }

    public void setTotalDocumentos(Integer totalDocumentos) {
        this.totalDocumentos = totalDocumentos;
    }

    public Integer getDocumentosFirmados() {
        return documentosFirmados;
    }

    public void setDocumentosFirmados(Integer documentosFirmados) {
        this.documentosFirmados = documentosFirmados;
    }

    public Integer getDocumentosFallidos() {
        return documentosFallidos;
    }

    public void setDocumentosFallidos(Integer documentosFallidos) {
        this.documentosFallidos = documentosFallidos;
    }

    public List<DocumentoLote> getResultadosDocumentos() {
        return resultadosDocumentos;
    }

    public void setResultadosDocumentos(List<DocumentoLote> resultadosDocumentos) {
        this.resultadosDocumentos = resultadosDocumentos;
    }

    public Firmante getFirmante() {
        return firmante;
    }

    public void setFirmante(Firmante firmante) {
        this.firmante = firmante;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
