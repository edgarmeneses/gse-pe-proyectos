package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Item de documento en listados
 */
public class DocumentoItemDto {
    private String documentoId;
    private String nombreDocumento;
    private String rutaDocumento;

    public DocumentoItemDto() {
    }

    public DocumentoItemDto(String documentoId, String nombreDocumento, String rutaDocumento) {
        this.documentoId = documentoId;
        this.nombreDocumento = nombreDocumento;
        this.rutaDocumento = rutaDocumento;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getRutaDocumento() {
        return rutaDocumento;
    }

    public void setRutaDocumento(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }
}
