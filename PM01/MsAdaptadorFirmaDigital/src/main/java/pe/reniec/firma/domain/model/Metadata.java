package pe.reniec.firma.domain.model;

import java.time.LocalDateTime;

public class Metadata {
    private String moduloOrigen;
    private String ipCliente;
    private String navegador;
    private String correlationId;
    private LocalDateTime timestamp;
    private String version;
    private Integer tiempoRespuestaMs;
    private String motivoValidacion;
    private Integer tiempoValidacionMs;

    public Metadata() {}

    public String getModuloOrigen() {
        return moduloOrigen;
    }

    public void setModuloOrigen(String moduloOrigen) {
        this.moduloOrigen = moduloOrigen;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public void setIpCliente(String ipCliente) {
        this.ipCliente = ipCliente;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
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

    public Integer getTiempoRespuestaMs() {
        return tiempoRespuestaMs;
    }

    public void setTiempoRespuestaMs(Integer tiempoRespuestaMs) {
        this.tiempoRespuestaMs = tiempoRespuestaMs;
    }

    public String getMotivoValidacion() {
        return motivoValidacion;
    }

    public void setMotivoValidacion(String motivoValidacion) {
        this.motivoValidacion = motivoValidacion;
    }

    public Integer getTiempoValidacionMs() {
        return tiempoValidacionMs;
    }

    public void setTiempoValidacionMs(Integer tiempoValidacionMs) {
        this.tiempoValidacionMs = tiempoValidacionMs;
    }
}
