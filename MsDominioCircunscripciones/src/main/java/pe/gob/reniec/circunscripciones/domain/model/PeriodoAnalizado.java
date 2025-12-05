package pe.gob.reniec.circunscripciones.domain.model;

import java.time.LocalDate;

public class PeriodoAnalizado {

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public PeriodoAnalizado() {
    }

    public PeriodoAnalizado(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
}
