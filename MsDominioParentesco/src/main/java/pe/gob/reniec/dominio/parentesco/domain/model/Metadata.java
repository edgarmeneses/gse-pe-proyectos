package pe.gob.reniec.dominio.parentesco.domain.model;

import java.time.LocalDateTime;

public class Metadata {
    private LocalDateTime timestamp;
    private String correlationId;
    private String version;
    private ServiciosConsultados serviciosConsultados;

    public Metadata() {
    }

    public Metadata(LocalDateTime timestamp, String correlationId, String version,
                   ServiciosConsultados serviciosConsultados) {
        this.timestamp = timestamp;
        this.correlationId = correlationId;
        this.version = version;
        this.serviciosConsultados = serviciosConsultados;
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

    public ServiciosConsultados getServiciosConsultados() {
        return serviciosConsultados;
    }

    public void setServiciosConsultados(ServiciosConsultados serviciosConsultados) {
        this.serviciosConsultados = serviciosConsultados;
    }
}
