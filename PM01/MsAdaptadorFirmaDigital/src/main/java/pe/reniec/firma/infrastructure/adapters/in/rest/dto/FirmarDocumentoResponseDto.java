package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

public class FirmarDocumentoResponseDto {
    private String status;
    private ProcesoFirmaDto data;
    private MetadataDto metadata;

    public FirmarDocumentoResponseDto() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProcesoFirmaDto getData() {
        return data;
    }

    public void setData(ProcesoFirmaDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
