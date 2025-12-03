package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

public class VigenciaEntity {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Boolean esVigente;

    public VigenciaEntity() {
    }

    public VigenciaEntity(LocalDateTime fechaInicio, LocalDateTime fechaFin, Boolean esVigente) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.esVigente = esVigente;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getEsVigente() {
        return esVigente;
    }

    public void setEsVigente(Boolean esVigente) {
        this.esVigente = esVigente;
    }
}
