package pe.gse.generadorreportecargaoffline.domain.model;

import java.time.LocalDateTime;

/**
 * Value Object: Metadata
 * Contiene metadatos de la operación (timestamp, correlationId, version).
 */
public class Metadata {

    private LocalDateTime timestamp;
    private String correlationId;
    private String version;

    public Metadata() {
    }

    public Metadata(LocalDateTime timestamp, String correlationId, String version) {
        this.timestamp = timestamp;
        this.correlationId = correlationId;
        this.version = version;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
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
