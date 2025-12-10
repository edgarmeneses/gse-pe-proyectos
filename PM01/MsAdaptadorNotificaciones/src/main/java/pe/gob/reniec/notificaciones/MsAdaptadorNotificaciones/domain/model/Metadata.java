package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Metadata {
    private String tramiteId;
    private String oficinaOrigen;
    private String tipoTramiteId;
    private LocalDateTime timestamp;
    private UUID correlationId;
    private String version;
    private String processingTime;
    private String sistemaOrigen;

    public Metadata() {}

    public String getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
    }

    public String getOficinaOrigen() {
        return oficinaOrigen;
    }

    public void setOficinaOrigen(String oficinaOrigen) {
        this.oficinaOrigen = oficinaOrigen;
    }

    public String getTipoTramiteId() {
        return tipoTramiteId;
    }

    public void setTipoTramiteId(String tipoTramiteId) {
        this.tipoTramiteId = tipoTramiteId;
    }

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

    public String getSistemaOrigen() {
        return sistemaOrigen;
    }

    public void setSistemaOrigen(String sistemaOrigen) {
        this.sistemaOrigen = sistemaOrigen;
    }
}
