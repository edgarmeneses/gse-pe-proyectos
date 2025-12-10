package pe.reniec.firma.domain.model;

import java.util.List;

public class SolicitudLote {
    private String loteId;
    private String descripcionLote;
    private List<DocumentoLote> documentos;
    private Firmante firmante;
    private ConfiguracionFirma configuracionFirma;
    private Metadata metadata;

    public SolicitudLote() {}

    public String getLoteId() {
        return loteId;
    }

    public void setLoteId(String loteId) {
        this.loteId = loteId;
    }

    public String getDescripcionLote() {
        return descripcionLote;
    }

    public void setDescripcionLote(String descripcionLote) {
        this.descripcionLote = descripcionLote;
    }

    public List<DocumentoLote> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoLote> documentos) {
        this.documentos = documentos;
    }

    public Firmante getFirmante() {
        return firmante;
    }

    public void setFirmante(Firmante firmante) {
        this.firmante = firmante;
    }

    public ConfiguracionFirma getConfiguracionFirma() {
        return configuracionFirma;
    }

    public void setConfiguracionFirma(ConfiguracionFirma configuracionFirma) {
        this.configuracionFirma = configuracionFirma;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
