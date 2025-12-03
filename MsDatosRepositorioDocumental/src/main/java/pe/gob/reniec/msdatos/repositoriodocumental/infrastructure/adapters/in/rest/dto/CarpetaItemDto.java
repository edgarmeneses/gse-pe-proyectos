package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;
import java.util.Objects;

/**
 * DTO: Item de carpeta en listados
 */
public class CarpetaItemDto {
    private final String id;
    private final Map<String, Object> metadata;
    private final String createdAt;

    public CarpetaItemDto(String id, Map<String, Object> metadata, String createdAt) {
        this.id = id;
        this.metadata = metadata;
        this.createdAt = createdAt;
    }

    public String id() { return id; }
    public Map<String, Object> metadata() { return metadata; }
    public String createdAt() { return createdAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarpetaItemDto that = (CarpetaItemDto) o;
        return Objects.equals(id, that.id) && Objects.equals(metadata, that.metadata) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, metadata, createdAt);
    }

    @Override
    public String toString() {
        return "CarpetaItemDto{" +
                "id='" + id + '\'' +
                ", metadata=" + metadata +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
