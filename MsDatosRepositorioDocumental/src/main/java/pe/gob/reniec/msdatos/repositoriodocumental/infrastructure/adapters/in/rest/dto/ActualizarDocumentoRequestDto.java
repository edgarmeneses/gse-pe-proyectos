package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;
import java.util.Objects;

/**
 * DTO Request: Actualizar Documento
 */
public class ActualizarDocumentoRequestDto {
    private final String archivoBase64;
    private final String carpetaId;
    private final Map<String, Object> metadata;
    private final String estadoDocumento;

    public ActualizarDocumentoRequestDto(String archivoBase64, String carpetaId, Map<String, Object> metadata, String estadoDocumento) {
        this.archivoBase64 = archivoBase64;
        this.carpetaId = carpetaId;
        this.metadata = metadata;
        this.estadoDocumento = estadoDocumento;
    }

    public String archivoBase64() { return archivoBase64; }
    public String carpetaId() { return carpetaId; }
    public Map<String, Object> metadata() { return metadata; }
    public String estadoDocumento() { return estadoDocumento; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActualizarDocumentoRequestDto that = (ActualizarDocumentoRequestDto) o;
        return Objects.equals(archivoBase64, that.archivoBase64) && Objects.equals(carpetaId, that.carpetaId) && Objects.equals(metadata, that.metadata) && Objects.equals(estadoDocumento, that.estadoDocumento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archivoBase64, carpetaId, metadata, estadoDocumento);
    }

    @Override
    public String toString() {
        return "ActualizarDocumentoRequestDto{" +
                "archivoBase64='" + archivoBase64 + '\'' +
                ", carpetaId='" + carpetaId + '\'' +
                ", metadata=" + metadata +
                ", estadoDocumento='" + estadoDocumento + '\'' +
                '}';
    }
}
