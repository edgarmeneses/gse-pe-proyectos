package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

/**
 * DTO para metadatos de la respuesta.
 */
public class MetadataDto {
    private LocalDateTime timestamp;
    private String correlationId;
    private String version;
    private ServiciosConsultadosDto serviciosConsultados;

    public MetadataDto() {}

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getCorrelationId() { return correlationId; }
    public void setCorrelationId(String correlationId) { this.correlationId = correlationId; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public ServiciosConsultadosDto getServiciosConsultados() { return serviciosConsultados; }
    public void setServiciosConsultados(ServiciosConsultadosDto serviciosConsultados) { this.serviciosConsultados = serviciosConsultados; }
}
