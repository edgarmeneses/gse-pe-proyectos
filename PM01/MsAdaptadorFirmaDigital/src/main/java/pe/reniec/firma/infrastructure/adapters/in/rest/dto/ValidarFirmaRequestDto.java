package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

public class ValidarFirmaRequestDto {
    private DocumentoDto documento;
    private ValidacionConfigDto validaciones;
    private MetadataDto metadata;

    public ValidarFirmaRequestDto() {}

    public DocumentoDto getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoDto documento) {
        this.documento = documento;
    }

    public ValidacionConfigDto getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(ValidacionConfigDto validaciones) {
        this.validaciones = validaciones;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
