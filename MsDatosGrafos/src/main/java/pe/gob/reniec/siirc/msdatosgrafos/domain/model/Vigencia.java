package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

import java.time.LocalDateTime;

/**
 * Value Object que representa el período de vigencia de un vínculo de parentesco.
 */
public class Vigencia {
    private final LocalDateTime fechaInicio;
    private final LocalDateTime fechaFin;

    public Vigencia(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    /**
     * Verifica si la vigencia está activa en este momento.
     */
    public boolean estaVigente() {
        LocalDateTime ahora = LocalDateTime.now();
        boolean despuesDeFechaInicio = fechaInicio == null || !ahora.isBefore(fechaInicio);
        boolean antesDeFechaFin = fechaFin == null || ahora.isBefore(fechaFin);
        return despuesDeFechaInicio && antesDeFechaFin;
    }

    /**
     * Verifica si la vigencia está activa en una fecha específica.
     */
    public boolean estaVigenteEn(LocalDateTime fecha) {
        if (fecha == null) {
            return false;
        }
        boolean despuesDeFechaInicio = fechaInicio == null || !fecha.isBefore(fechaInicio);
        boolean antesDeFechaFin = fechaFin == null || fecha.isBefore(fechaFin);
        return despuesDeFechaInicio && antesDeFechaFin;
    }
}
