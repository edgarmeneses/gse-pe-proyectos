package pe.gob.reniec.hechosVitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO: MetadataDto
 * 
 * Representa los metadatos de la respuesta para trazabilidad.
 */
public class MetadataDto {
    
    private String timestamp;
    private String correlationId;
    private String version;
    private String proveedor;
    
    public MetadataDto() {
    }
    
    public MetadataDto(String timestamp, String correlationId, String version, String proveedor) {
        this.timestamp = timestamp;
        this.correlationId = correlationId;
        this.version = version;
        this.proveedor = proveedor;
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
    
    public String getProveedor() {
        return proveedor;
    }
    
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
}
