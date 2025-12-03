package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Response: Actualizar Documento
 */
public class ActualizarDocumentoResponseDto {
    private String id;
    private List<String> camposActualizados;
    private String updatedAt;
    private String estadoDocumento;

    public ActualizarDocumentoResponseDto() {
    }

    public ActualizarDocumentoResponseDto(String id, List<String> camposActualizados, String updatedAt, String estadoDocumento) {
        this.id = id;
        this.camposActualizados = camposActualizados;
        this.updatedAt = updatedAt;
        this.estadoDocumento = estadoDocumento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCamposActualizados() {
        return camposActualizados;
    }

    public void setCamposActualizados(List<String> camposActualizados) {
        this.camposActualizados = camposActualizados;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(String estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }
}
