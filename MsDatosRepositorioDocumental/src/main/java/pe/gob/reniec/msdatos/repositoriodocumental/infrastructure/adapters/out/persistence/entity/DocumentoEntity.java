package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.Map;

public class DocumentoEntity {
    private String id;
    private String archivoBase64;
    private String carpetaId;
    private Map<String, Object> metadata;
    private String estadoDocumento;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DocumentoEntity() {
    }

    public DocumentoEntity(String id, String archivoBase64, String carpetaId, Map<String, Object> metadata,
                          String estadoDocumento, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.archivoBase64 = archivoBase64;
        this.carpetaId = carpetaId;
        this.metadata = metadata;
        this.estadoDocumento = estadoDocumento;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArchivoBase64() {
        return archivoBase64;
    }

    public void setArchivoBase64(String archivoBase64) {
        this.archivoBase64 = archivoBase64;
    }

    public String getCarpetaId() {
        return carpetaId;
    }

    public void setCarpetaId(String carpetaId) {
        this.carpetaId = carpetaId;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(String estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
