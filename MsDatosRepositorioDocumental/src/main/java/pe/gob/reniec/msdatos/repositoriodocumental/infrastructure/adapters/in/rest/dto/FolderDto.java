package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;
import java.util.Objects;

/**
 * DTO: Información de carpeta
 */
public class FolderDto {
    private final String id;
    private final Map<String, Object> metadata;
    private final String path;
    private final String estadoCarpeta;
    private final String createdAt;
    private final String updatedAt;

    public FolderDto(String id, Map<String, Object> metadata, String path, String estadoCarpeta, String createdAt, String updatedAt) {
        this.id = id;
        this.metadata = metadata;
        this.path = path;
        this.estadoCarpeta = estadoCarpeta;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String id() { return id; }
    public Map<String, Object> metadata() { return metadata; }
    public String path() { return path; }
    public String estadoCarpeta() { return estadoCarpeta; }
    public String createdAt() { return createdAt; }
    public String updatedAt() { return updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FolderDto folderDto = (FolderDto) o;
        return Objects.equals(id, folderDto.id) && Objects.equals(metadata, folderDto.metadata) && Objects.equals(path, folderDto.path) && Objects.equals(estadoCarpeta, folderDto.estadoCarpeta) && Objects.equals(createdAt, folderDto.createdAt) && Objects.equals(updatedAt, folderDto.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, metadata, path, estadoCarpeta, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "FolderDto{" +
                "id='" + id + '\'' +
                ", metadata=" + metadata +
                ", path='" + path + '\'' +
                ", estadoCarpeta='" + estadoCarpeta + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
