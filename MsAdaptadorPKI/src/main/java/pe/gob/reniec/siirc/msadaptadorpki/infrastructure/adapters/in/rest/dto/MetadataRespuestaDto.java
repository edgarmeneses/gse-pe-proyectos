package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto;

public class MetadataRespuestaDto {
    private String correlationId;
    private String requestId;
    private String timestamp;
    private String version;

    public MetadataRespuestaDto() {
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
