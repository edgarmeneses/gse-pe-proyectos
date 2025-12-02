package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;

/**
 * Entity para persistencia de Vigencia
 * POJO sin anotaciones de framework
 */
public class VigenciaEntity {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean esVigente;

    public VigenciaEntity() {
    }

    public VigenciaEntity(LocalDate fechaInicio, LocalDate fechaFin, Boolean esVigente) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.esVigente = esVigente;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getEsVigente() {
        return esVigente;
    }

    public void setEsVigente(Boolean esVigente) {
        this.esVigente = esVigente;
    }
}
