package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

public class DocumentoLoteDto extends DocumentoDto {
    private String documentoId;
    private String tramiteId;
    private String estado;
    private String procesoFirmaId;
    private String timestampFirma;

    public DocumentoLoteDto() {}

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public String getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProcesoFirmaId() {
        return procesoFirmaId;
    }

    public void setProcesoFirmaId(String procesoFirmaId) {
        this.procesoFirmaId = procesoFirmaId;
    }

    public String getTimestampFirma() {
        return timestampFirma;
    }

    public void setTimestampFirma(String timestampFirma) {
        this.timestampFirma = timestampFirma;
    }
}
