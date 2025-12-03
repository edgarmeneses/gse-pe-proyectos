package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO Request: Actualizar Documento
 */
public class ActualizarDocumentoRequestDto {
    private String archivoBase64;
    private String carpetaId;
    private Map<String, Object> metadata;
    private String estadoDocumento;

    public ActualizarDocumentoRequestDto() {
    }

    public ActualizarDocumentoRequestDto(String archivoBase64, String carpetaId, Map<String, Object> metadata, String estadoDocumento) {
        this.archivoBase64 = archivoBase64;
        this.carpetaId = carpetaId;
        this.metadata = metadata;
        this.estadoDocumento = estadoDocumento;
    }

    public String getArchivoBase64() {
        return archivoBase64;
    }

    public void setArchivoBase64(String archivoBase64) {
        this.archivoBase64 = archivoBase64;
    }

    public String getCarpetaId() {
        return carpetaId;
    }

    public void setCarpetaId(String carpetaId) {
        this.carpetaId = carpetaId;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(String estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }
}
