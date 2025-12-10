package pe.reniec.firma.domain.model;

public class SolicitudFirma {
    private String tramiteId;
    private Documento documento;
    private Firmante firmante;
    private ConfiguracionFirma configuracionFirma;
    private Metadata metadata;

    public SolicitudFirma() {}

    public String getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
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
