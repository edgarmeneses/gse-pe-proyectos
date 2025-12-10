package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

public class FirmarDocumentoRequestDto {
    private String tramiteId;
    private DocumentoDto documento;
    private FirmanteDto firmante;
    private ConfiguracionFirmaDto configuracionFirma;
    private MetadataDto metadata;

    public FirmarDocumentoRequestDto() {}

    public String getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
    }

    public DocumentoDto getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoDto documento) {
        this.documento = documento;
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

    // Inner DTOs or separate files? I'll put them here for simplicity or create separate common DTOs.
    // Given the prompt structure, I'll create separate files for common DTOs if reused.
    // DocumentoDto, FirmanteDto, etc. are reused.
}
