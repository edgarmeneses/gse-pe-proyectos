package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

import java.time.LocalDate;

/**
 * Value Object que representa la vigencia de una relación de parentesco
 */
public class Vigencia {
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private final Boolean esVigente;

    public Vigencia(LocalDate fechaInicio, LocalDate fechaFin, Boolean esVigente) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.esVigente = esVigente;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Boolean getEsVigente() {
        return esVigente;
    }
}
