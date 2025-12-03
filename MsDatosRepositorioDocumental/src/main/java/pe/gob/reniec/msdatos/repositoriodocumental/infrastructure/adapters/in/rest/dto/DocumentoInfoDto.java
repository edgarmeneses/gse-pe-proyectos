package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO: Información detallada de documento
 */
public class DocumentoInfoDto {
    private String id;
    private Map<String, Object> metadata;
    private String createdAt;

    public DocumentoInfoDto() {
    }

    public DocumentoInfoDto(String id, Map<String, Object> metadata, String createdAt) {
        this.id = id;
        this.metadata = metadata;
        this.createdAt = createdAt;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
