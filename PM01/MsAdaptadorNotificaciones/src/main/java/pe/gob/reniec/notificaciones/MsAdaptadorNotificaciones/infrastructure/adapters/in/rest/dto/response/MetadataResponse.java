package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.infrastructure.adapters.in.rest.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class MetadataResponse {
    private LocalDateTime timestamp;
    private UUID correlationId;
    private String version;
    private String processingTime;

    public MetadataResponse() {}

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public UUID getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(UUID correlationId) {
        this.correlationId = correlationId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(String processingTime) {
        this.processingTime = processingTime;
    }
}
