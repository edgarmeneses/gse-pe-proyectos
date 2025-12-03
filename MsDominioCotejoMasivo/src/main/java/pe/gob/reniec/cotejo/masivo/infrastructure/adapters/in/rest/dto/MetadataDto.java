package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

public class MetadataDto {
    private String timestamp;
    private String correlationId;
    private String version;

    public MetadataDto() {
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
