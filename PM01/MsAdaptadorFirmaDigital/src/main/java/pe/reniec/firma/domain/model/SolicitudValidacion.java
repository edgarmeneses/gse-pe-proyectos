package pe.reniec.firma.domain.model;

public class SolicitudValidacion {
    private Documento documento;
    private ValidacionConfig validaciones;
    private Metadata metadata;

    public SolicitudValidacion() {}

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public ValidacionConfig getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(ValidacionConfig validaciones) {
        this.validaciones = validaciones;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
