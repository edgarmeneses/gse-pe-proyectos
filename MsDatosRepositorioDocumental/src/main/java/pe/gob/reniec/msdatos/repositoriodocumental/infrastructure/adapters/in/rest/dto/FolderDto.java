package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO: Información de carpeta
 */
public class FolderDto {
    private String id;
    private Map<String, Object> metadata;
    private String path;
    private String estadoCarpeta;
    private String createdAt;
    private String updatedAt;

    public FolderDto() {
    }

    public FolderDto(String id, Map<String, Object> metadata, String path, String estadoCarpeta, String createdAt, String updatedAt) {
        this.id = id;
        this.metadata = metadata;
        this.path = path;
        this.estadoCarpeta = estadoCarpeta;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEstadoCarpeta() {
        return estadoCarpeta;
    }

    public void setEstadoCarpeta(String estadoCarpeta) {
        this.estadoCarpeta = estadoCarpeta;
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
