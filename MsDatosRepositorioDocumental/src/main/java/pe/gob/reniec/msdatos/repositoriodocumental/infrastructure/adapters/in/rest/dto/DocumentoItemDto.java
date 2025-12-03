package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Objects;

/**
 * DTO: Item de documento en listados
 */
public class DocumentoItemDto {
    private final String documentoId;
    private final String nombreDocumento;
    private final String rutaDocumento;

    public DocumentoItemDto(String documentoId, String nombreDocumento, String rutaDocumento) {
        this.documentoId = documentoId;
        this.nombreDocumento = nombreDocumento;
        this.rutaDocumento = rutaDocumento;
    }

    public String documentoId() { return documentoId; }
    public String nombreDocumento() { return nombreDocumento; }
    public String rutaDocumento() { return rutaDocumento; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoItemDto that = (DocumentoItemDto) o;
        return Objects.equals(documentoId, that.documentoId) && Objects.equals(nombreDocumento, that.nombreDocumento) && Objects.equals(rutaDocumento, that.rutaDocumento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentoId, nombreDocumento, rutaDocumento);
    }

    @Override
    public String toString() {
        return "DocumentoItemDto{" +
                "documentoId='" + documentoId + '\'' +
                ", nombreDocumento='" + nombreDocumento + '\'' +
                ", rutaDocumento='" + rutaDocumento + '\'' +
                '}';
    }
}
