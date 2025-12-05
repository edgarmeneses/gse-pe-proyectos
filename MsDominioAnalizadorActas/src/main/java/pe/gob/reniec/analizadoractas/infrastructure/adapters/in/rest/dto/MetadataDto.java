package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Metadatos de la operación
 */
public class MetadataDto {

    private String timestamp;
    private String correlationId;
    private String version;

    public MetadataDto() {
    }

    public MetadataDto(String timestamp, String correlationId, String version) {
        this.timestamp = timestamp;
        this.correlationId = correlationId;
        this.version = version;
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
}
