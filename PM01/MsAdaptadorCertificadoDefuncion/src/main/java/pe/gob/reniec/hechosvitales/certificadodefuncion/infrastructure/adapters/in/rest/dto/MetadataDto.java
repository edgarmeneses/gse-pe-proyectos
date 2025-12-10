package pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Metadatos de la respuesta
 */
public class MetadataDto {

    private String timestamp;
    private String correlationId;
    private String version;
    private String source;

    public MetadataDto() {
    }

    public MetadataDto(String timestamp, String correlationId, String version, String source) {
        this.timestamp = timestamp;
        this.correlationId = correlationId;
        this.version = version;
        this.source = source;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
