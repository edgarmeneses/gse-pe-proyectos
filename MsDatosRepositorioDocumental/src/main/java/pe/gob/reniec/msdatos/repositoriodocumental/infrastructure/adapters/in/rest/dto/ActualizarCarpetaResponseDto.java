package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Response: Actualizar Carpeta
 */
public class ActualizarCarpetaResponseDto {
    private String id;
    private String updatedAt;
    private List<String> camposActualizados;

    public ActualizarCarpetaResponseDto() {
    }

    public ActualizarCarpetaResponseDto(String id, String updatedAt, List<String> camposActualizados) {
        this.id = id;
        this.updatedAt = updatedAt;
        this.camposActualizados = camposActualizados;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getCamposActualizados() {
        return camposActualizados;
    }

    public void setCamposActualizados(List<String> camposActualizados) {
        this.camposActualizados = camposActualizados;
    }
}
