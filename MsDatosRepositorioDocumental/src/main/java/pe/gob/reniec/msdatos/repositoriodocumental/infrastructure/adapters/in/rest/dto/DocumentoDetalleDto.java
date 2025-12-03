package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Objects;

/**
 * DTO: Detalle completo de documento
 */
public class DocumentoDetalleDto {
    private final String documentoId;
    private final String nombreDocumento;
    private final String tipoDocumento;
    private final String rutaDocumento;
    private final String carpetaId;
    private final String estadoDocumento;
    private final String mimeType;
    private final Integer tamanioBytes;
    private final String createdAt;
    private final String updatedAt;

    public DocumentoDetalleDto(String documentoId, String nombreDocumento, String tipoDocumento, String rutaDocumento, String carpetaId, String estadoDocumento, String mimeType, Integer tamanioBytes, String createdAt, String updatedAt) {
        this.documentoId = documentoId;
        this.nombreDocumento = nombreDocumento;
        this.tipoDocumento = tipoDocumento;
        this.rutaDocumento = rutaDocumento;
        this.carpetaId = carpetaId;
        this.estadoDocumento = estadoDocumento;
        this.mimeType = mimeType;
        this.tamanioBytes = tamanioBytes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String documentoId() { return documentoId; }
    public String nombreDocumento() { return nombreDocumento; }
    public String tipoDocumento() { return tipoDocumento; }
    public String rutaDocumento() { return rutaDocumento; }
    public String carpetaId() { return carpetaId; }
    public String estadoDocumento() { return estadoDocumento; }
    public String mimeType() { return mimeType; }
    public Integer tamanioBytes() { return tamanioBytes; }
    public String createdAt() { return createdAt; }
    public String updatedAt() { return updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoDetalleDto that = (DocumentoDetalleDto) o;
        return Objects.equals(documentoId, that.documentoId) && Objects.equals(nombreDocumento, that.nombreDocumento) && Objects.equals(tipoDocumento, that.tipoDocumento) && Objects.equals(rutaDocumento, that.rutaDocumento) && Objects.equals(carpetaId, that.carpetaId) && Objects.equals(estadoDocumento, that.estadoDocumento) && Objects.equals(mimeType, that.mimeType) && Objects.equals(tamanioBytes, that.tamanioBytes) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentoId, nombreDocumento, tipoDocumento, rutaDocumento, carpetaId, estadoDocumento, mimeType, tamanioBytes, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "DocumentoDetalleDto{" +
                "documentoId='" + documentoId + '\'' +
                ", nombreDocumento='" + nombreDocumento + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", rutaDocumento='" + rutaDocumento + '\'' +
                ", carpetaId='" + carpetaId + '\'' +
                ", estadoDocumento='" + estadoDocumento + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", tamanioBytes=" + tamanioBytes +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
