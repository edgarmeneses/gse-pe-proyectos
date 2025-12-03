package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Map;

/**
 * DTO Response: Consultar Documento
 */
public class ConsultarDocumentoResponseDto {
    private String archivo;
    private String carpetaId;
    private Map<String, Object> metadata;
    private String estadoDocumento;

    public ConsultarDocumentoResponseDto() {
    }

    public ConsultarDocumentoResponseDto(String archivo, String carpetaId, Map<String, Object> metadata, String estadoDocumento) {
        this.archivo = archivo;
        this.carpetaId = carpetaId;
        this.metadata = metadata;
        this.estadoDocumento = estadoDocumento;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
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
