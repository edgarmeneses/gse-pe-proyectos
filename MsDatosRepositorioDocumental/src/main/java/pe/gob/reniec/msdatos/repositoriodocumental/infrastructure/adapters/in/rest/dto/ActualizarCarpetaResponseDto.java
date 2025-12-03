package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO Response: Actualizar Carpeta
 */
public class ActualizarCarpetaResponseDto {
    private final String id;
    private final String updatedAt;
    private final List<String> camposActualizados;

    public ActualizarCarpetaResponseDto(String id, String updatedAt, List<String> camposActualizados) {
        this.id = id;
        this.updatedAt = updatedAt;
        this.camposActualizados = camposActualizados;
    }

    public String id() { return id; }
    public String updatedAt() { return updatedAt; }
    public List<String> camposActualizados() { return camposActualizados; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActualizarCarpetaResponseDto that = (ActualizarCarpetaResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(camposActualizados, that.camposActualizados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, updatedAt, camposActualizados);
    }

    @Override
    public String toString() {
        return "ActualizarCarpetaResponseDto{" +
                "id='" + id + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", camposActualizados=" + camposActualizados +
                '}';
    }
}
