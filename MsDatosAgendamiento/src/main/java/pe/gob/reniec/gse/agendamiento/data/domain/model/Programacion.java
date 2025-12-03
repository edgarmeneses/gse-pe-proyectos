package pe.gob.reniec.gse.agendamiento.data.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Programacion {
    
    private final LocalDate fechaCita;
    private final LocalTime horaCita;
    private final String idDisponibilidad;
    
    public Programacion(LocalDate fechaCita, LocalTime horaCita, String idDisponibilidad) {
        if (fechaCita == null) {
            throw new IllegalArgumentException("La fecha de la cita es requerida");
        }
        if (horaCita == null) {
            throw new IllegalArgumentException("La hora de la cita es requerida");
        }
        if (idDisponibilidad == null || idDisponibilidad.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de disponibilidad es requerido");
        }
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.idDisponibilidad = idDisponibilidad.trim();
    }
    
    public LocalDate getFechaCita() {
        return fechaCita;
    }
    
    public LocalTime getHoraCita() {
        return horaCita;
    }
    
    public String getIdDisponibilidad() {
        return idDisponibilidad;
    }
    
    public LocalDateTime getFechaHoraCompleta() {
        return LocalDateTime.of(fechaCita, horaCita);
    }
    
    public boolean esEnElPasado() {
        return getFechaHoraCompleta().isBefore(LocalDateTime.now());
    }
    
    public boolean esEnElFuturo() {
        return getFechaHoraCompleta().isAfter(LocalDateTime.now());
    }
}
