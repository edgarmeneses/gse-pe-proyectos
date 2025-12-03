package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;
import java.util.Objects;

/**
 * DTO Request: Crear Documento
 */
public class CrearDocumentoRequestDto {
    private final String archivoBase64;
    private final String carpetaId;
    private final Map<String, Object> metadata;

    public CrearDocumentoRequestDto(String archivoBase64, String carpetaId, Map<String, Object> metadata) {
        this.archivoBase64 = archivoBase64;
        this.carpetaId = carpetaId;
        this.metadata = metadata;
    }

    public String archivoBase64() { return archivoBase64; }
    public String carpetaId() { return carpetaId; }
    public Map<String, Object> metadata() { return metadata; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrearDocumentoRequestDto that = (CrearDocumentoRequestDto) o;
        return Objects.equals(archivoBase64, that.archivoBase64) && Objects.equals(carpetaId, that.carpetaId) && Objects.equals(metadata, that.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archivoBase64, carpetaId, metadata);
    }

    @Override
    public String toString() {
        return "CrearDocumentoRequestDto{" +
                "archivoBase64='" + archivoBase64 + '\'' +
                ", carpetaId='" + carpetaId + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
