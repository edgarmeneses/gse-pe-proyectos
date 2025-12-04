package pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public class ValidarSustentoResponseDto {
    private Long tachaReclamoId;
    private Boolean esValido;
    private String observaciones;
    private LocalDateTime fechaValidacion;
    private String statusCode;
    private String message;

    public ValidarSustentoResponseDto() {
    }

    public Long getTachaReclamoId() {
        return tachaReclamoId;
    }

    public void setTachaReclamoId(Long tachaReclamoId) {
        this.tachaReclamoId = tachaReclamoId;
    }

    public Boolean getEsValido() {
        return esValido;
    }

    public void setEsValido(Boolean esValido) {
        this.esValido = esValido;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaValidacion() {
        return fechaValidacion;
    }

    public void setFechaValidacion(LocalDateTime fechaValidacion) {
        this.fechaValidacion = fechaValidacion;
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
