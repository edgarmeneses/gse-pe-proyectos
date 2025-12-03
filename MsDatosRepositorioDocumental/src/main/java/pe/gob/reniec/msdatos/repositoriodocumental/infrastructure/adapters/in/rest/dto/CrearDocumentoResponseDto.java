package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO Response: Crear Documento
 */
public class CrearDocumentoResponseDto {
    private String id;
    private Object metadata;
    private String createdAt;
    private String estadoDocumento;

    public CrearDocumentoResponseDto() {
    }

    public CrearDocumentoResponseDto(String id, Object metadata, String createdAt, String estadoDocumento) {
        this.id = id;
        this.metadata = metadata;
        this.createdAt = createdAt;
        this.estadoDocumento = estadoDocumento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(String estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }
}
