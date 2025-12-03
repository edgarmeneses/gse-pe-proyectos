package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;
import java.util.Objects;

/**
 * DTO Response: Consultar Documento
 */
public class ConsultarDocumentoResponseDto {
    private final String archivo;
    private final String carpetaId;
    private final Map<String, Object> metadata;
    private final String estadoDocumento;

    public ConsultarDocumentoResponseDto(String archivo, String carpetaId, Map<String, Object> metadata, String estadoDocumento) {
        this.archivo = archivo;
        this.carpetaId = carpetaId;
        this.metadata = metadata;
        this.estadoDocumento = estadoDocumento;
    }

    public String archivo() { return archivo; }
    public String carpetaId() { return carpetaId; }
    public Map<String, Object> metadata() { return metadata; }
    public String estadoDocumento() { return estadoDocumento; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultarDocumentoResponseDto that = (ConsultarDocumentoResponseDto) o;
        return Objects.equals(archivo, that.archivo) && Objects.equals(carpetaId, that.carpetaId) && Objects.equals(metadata, that.metadata) && Objects.equals(estadoDocumento, that.estadoDocumento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archivo, carpetaId, metadata, estadoDocumento);
    }

    @Override
    public String toString() {
        return "ConsultarDocumentoResponseDto{" +
                "archivo='" + archivo + '\'' +
                ", carpetaId='" + carpetaId + '\'' +
                ", metadata=" + metadata +
                ", estadoDocumento='" + estadoDocumento + '\'' +
                '}';
    }
}
