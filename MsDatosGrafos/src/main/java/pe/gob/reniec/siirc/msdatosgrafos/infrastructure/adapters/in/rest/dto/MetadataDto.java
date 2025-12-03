package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

public class MetadataDto {
    private String timestamp;
    private String correlationId;
    private String version;
    private String tiempoRespuesta;

    public MetadataDto() {
    }

    public MetadataDto(String timestamp, String correlationId, String version, String tiempoRespuesta) {
        this.timestamp = timestamp;
        this.correlationId = correlationId;
        this.version = version;
        this.tiempoRespuesta = tiempoRespuesta;
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

    public String getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    public void setTiempoRespuesta(String tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta;
    }
}
