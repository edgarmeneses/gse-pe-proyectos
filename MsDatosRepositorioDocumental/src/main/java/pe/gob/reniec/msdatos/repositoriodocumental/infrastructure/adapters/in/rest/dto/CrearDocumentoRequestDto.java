package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO Request: Crear Documento
 */
public class CrearDocumentoRequestDto {
    private String archivoBase64;
    private String carpetaId;
    private Map<String, Object> metadata;

    public CrearDocumentoRequestDto() {
    }

    public CrearDocumentoRequestDto(String archivoBase64, String carpetaId, Map<String, Object> metadata) {
        this.archivoBase64 = archivoBase64;
        this.carpetaId = carpetaId;
        this.metadata = metadata;
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
}
