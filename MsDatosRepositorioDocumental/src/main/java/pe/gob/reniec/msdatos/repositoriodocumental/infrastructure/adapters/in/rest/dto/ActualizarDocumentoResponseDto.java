package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO Response: Actualizar Documento
 */
public class ActualizarDocumentoResponseDto {
    private final String id;
    private final List<String> camposActualizados;
    private final String updatedAt;
    private final String estadoDocumento;

    public ActualizarDocumentoResponseDto(String id, List<String> camposActualizados, String updatedAt, String estadoDocumento) {
        this.id = id;
        this.camposActualizados = camposActualizados;
        this.updatedAt = updatedAt;
        this.estadoDocumento = estadoDocumento;
    }

    public String id() { return id; }
    public List<String> camposActualizados() { return camposActualizados; }
    public String updatedAt() { return updatedAt; }
    public String estadoDocumento() { return estadoDocumento; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActualizarDocumentoResponseDto that = (ActualizarDocumentoResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(camposActualizados, that.camposActualizados) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(estadoDocumento, that.estadoDocumento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, camposActualizados, updatedAt, estadoDocumento);
    }

    @Override
    public String toString() {
        return "ActualizarDocumentoResponseDto{" +
                "id='" + id + '\'' +
                ", camposActualizados=" + camposActualizados +
                ", updatedAt='" + updatedAt + '\'' +
                ", estadoDocumento='" + estadoDocumento + '\'' +
                '}';
    }
}
