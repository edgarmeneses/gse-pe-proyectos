package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Detalle completo de documento
 */
public class DocumentoDetalleDto {
    private String documentoId;
    private String nombreDocumento;
    private String tipoDocumento;
    private String rutaDocumento;
    private String carpetaId;
    private String estadoDocumento;
    private String mimeType;
    private Integer tamanioBytes;
    private String createdAt;
    private String updatedAt;

    public DocumentoDetalleDto() {
    }

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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getRutaDocumento() {
        return rutaDocumento;
    }

    public void setRutaDocumento(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }

    public String getCarpetaId() {
        return carpetaId;
    }

    public void setCarpetaId(String carpetaId) {
        this.carpetaId = carpetaId;
    }

    public String getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(String estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Integer getTamanioBytes() {
        return tamanioBytes;
    }

    public void setTamanioBytes(Integer tamanioBytes) {
        this.tamanioBytes = tamanioBytes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
