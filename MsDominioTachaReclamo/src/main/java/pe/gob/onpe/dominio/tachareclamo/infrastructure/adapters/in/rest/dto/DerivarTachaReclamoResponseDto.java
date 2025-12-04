package pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public class DerivarTachaReclamoResponseDto {
    private Long id;
    private String numeroExpediente;
    private String estadoAnterior;
    private String estadoActual;
    private String areaDestino;
    private LocalDateTime fechaDerivacion;
    private String statusCode;
    private String message;

    public DerivarTachaReclamoResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getAreaDestino() {
        return areaDestino;
    }

    public void setAreaDestino(String areaDestino) {
        this.areaDestino = areaDestino;
    }

    public LocalDateTime getFechaDerivacion() {
        return fechaDerivacion;
    }

    public void setFechaDerivacion(LocalDateTime fechaDerivacion) {
        this.fechaDerivacion = fechaDerivacion;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
