package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Objects;

/**
 * DTO Response: Crear Documento
 */
public class CrearDocumentoResponseDto {
    private final String id;
    private final Object metadata;
    private final String createdAt;
    private final String estadoDocumento;

    public CrearDocumentoResponseDto(String id, Object metadata, String createdAt, String estadoDocumento) {
        this.id = id;
        this.metadata = metadata;
        this.createdAt = createdAt;
        this.estadoDocumento = estadoDocumento;
    }

    public String id() { return id; }
    public Object metadata() { return metadata; }
    public String createdAt() { return createdAt; }
    public String estadoDocumento() { return estadoDocumento; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrearDocumentoResponseDto that = (CrearDocumentoResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(metadata, that.metadata) && Objects.equals(createdAt, that.createdAt) && Objects.equals(estadoDocumento, that.estadoDocumento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, metadata, createdAt, estadoDocumento);
    }

    @Override
    public String toString() {
        return "CrearDocumentoResponseDto{" +
                "id='" + id + '\'' +
                ", metadata=" + metadata +
                ", createdAt='" + createdAt + '\'' +
                ", estadoDocumento='" + estadoDocumento + '\'' +
                '}';
    }
}
