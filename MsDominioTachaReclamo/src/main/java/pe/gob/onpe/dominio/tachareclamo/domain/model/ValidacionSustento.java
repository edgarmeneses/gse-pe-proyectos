package pe.gob.onpe.dominio.tachareclamo.domain.model;

import java.time.LocalDateTime;

public class ValidacionSustento {
    private Long id;
    private Long tachaReclamoId;
    private Boolean esValido;
    private String observaciones;
    private LocalDateTime fechaValidacion;
    private String validadoPor;

    public ValidacionSustento() {
    }

    public ValidacionSustento(Long id, Long tachaReclamoId, Boolean esValido,
                             String observaciones, LocalDateTime fechaValidacion, String validadoPor) {
        this.id = id;
        this.tachaReclamoId = tachaReclamoId;
        this.esValido = esValido;
        this.observaciones = observaciones;
        this.fechaValidacion = fechaValidacion;
        this.validadoPor = validadoPor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getValidadoPor() {
        return validadoPor;
    }

    public void setValidadoPor(String validadoPor) {
        this.validadoPor = validadoPor;
    }
}
