package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO para metadata de la respuesta
 */
public class MetadataResponseDto {
    
    private String timestamp;
    private String correlationId;
    private String tiempoRespuesta;
    
    public MetadataResponseDto() {
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
    
    public String getTiempoRespuesta() {
        return tiempoRespuesta;
    }
    
    public void setTiempoRespuesta(String tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta;
    }
}
