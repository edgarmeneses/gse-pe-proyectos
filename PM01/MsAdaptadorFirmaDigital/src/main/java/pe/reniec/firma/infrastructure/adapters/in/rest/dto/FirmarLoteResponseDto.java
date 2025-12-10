package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class FirmarLoteResponseDto {
    private String loteId;
    private String procesoLoteId;
    private String estadoLote;
    private Integer totalDocumentos;
    private Integer documentosFirmados;
    private Integer documentosFallidos;
    private List<DocumentoLoteDto> resultadosDocumentos;
    private FirmanteDto firmante;
    private AuditoriaDto auditoria;
    private MetadataDto metadata;

    public FirmarLoteResponseDto() {}

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

    public List<DocumentoLoteDto> getResultadosDocumentos() {
        return resultadosDocumentos;
    }

    public void setResultadosDocumentos(List<DocumentoLoteDto> resultadosDocumentos) {
        this.resultadosDocumentos = resultadosDocumentos;
    }

    public FirmanteDto getFirmante() {
        return firmante;
    }

    public void setFirmante(FirmanteDto firmante) {
        this.firmante = firmante;
    }

    public AuditoriaDto getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaDto auditoria) {
        this.auditoria = auditoria;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
