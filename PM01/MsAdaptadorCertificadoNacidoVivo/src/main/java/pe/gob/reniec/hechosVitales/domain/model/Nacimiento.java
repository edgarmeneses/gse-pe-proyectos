package pe.gob.reniec.hechosVitales.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Nacimiento {
    private final LocalDate fecha;
    private final LocalTime hora;

    public Nacimiento(LocalDate fecha, LocalTime hora) {
        this.fecha = Objects.requireNonNull(fecha, "La fecha de nacimiento es obligatoria");
        this.hora = Objects.requireNonNull(hora, "La hora de nacimiento es obligatoria");
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }
}
