package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class FirmarLoteRequestDto {
    private String loteId;
    private String descripcionLote;
    private List<DocumentoLoteDto> documentos;
    private FirmanteDto firmante;
    private ConfiguracionFirmaDto configuracionFirma;
    private MetadataDto metadata;

    public FirmarLoteRequestDto() {}

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

    public List<DocumentoLoteDto> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoLoteDto> documentos) {
        this.documentos = documentos;
    }

    public FirmanteDto getFirmante() {
        return firmante;
    }

    public void setFirmante(FirmanteDto firmante) {
        this.firmante = firmante;
    }

    public ConfiguracionFirmaDto getConfiguracionFirma() {
        return configuracionFirma;
    }

    public void setConfiguracionFirma(ConfiguracionFirmaDto configuracionFirma) {
        this.configuracionFirma = configuracionFirma;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
