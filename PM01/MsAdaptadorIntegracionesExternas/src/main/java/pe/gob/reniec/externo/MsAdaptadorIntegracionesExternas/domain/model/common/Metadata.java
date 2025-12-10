package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.common;

public class Metadata {
    private String timestamp;
    private String correlationId;
    private String tiempoRespuesta;
    private String proveedor;

    public Metadata() {}

    public Metadata(String timestamp, String correlationId, String tiempoRespuesta, String proveedor) {
        this.timestamp = timestamp;
        this.correlationId = correlationId;
        this.tiempoRespuesta = tiempoRespuesta;
        this.proveedor = proveedor;
    }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public String getCorrelationId() { return correlationId; }
    public void setCorrelationId(String correlationId) { this.correlationId = correlationId; }

    public String getTiempoRespuesta() { return tiempoRespuesta; }
    public void setTiempoRespuesta(String tiempoRespuesta) { this.tiempoRespuesta = tiempoRespuesta; }

    public String getProveedor() { return proveedor; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }
}
