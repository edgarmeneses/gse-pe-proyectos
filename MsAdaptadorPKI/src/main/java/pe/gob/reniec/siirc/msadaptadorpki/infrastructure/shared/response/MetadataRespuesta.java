package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response;

import java.time.LocalDateTime;

/**
 * Metadata técnica de respuesta HTTP.
 * Contiene información técnica sobre la respuesta del servicio.
 * NO es un concepto del dominio de negocio.
 */
public class MetadataRespuesta {
    private String correlationId;
    private String requestId;
    private LocalDateTime timestamp;
    private String version;

    public MetadataRespuesta() {
    }

    public MetadataRespuesta(String correlationId, String requestId, LocalDateTime timestamp, String version) {
        this.correlationId = correlationId;
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.version = version;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
