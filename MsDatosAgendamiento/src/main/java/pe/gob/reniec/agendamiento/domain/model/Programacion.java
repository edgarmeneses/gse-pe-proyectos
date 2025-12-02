package pe.gob.reniec.agendamiento.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Programacion {
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private LocalDateTime fechaHoraCompleta;
    private String idDisponibilidad;

    public Programacion() {
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalTime getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(LocalTime horaCita) {
        this.horaCita = horaCita;
    }

    public LocalDateTime getFechaHoraCompleta() {
        return fechaHoraCompleta;
    }

    public void setFechaHoraCompleta(LocalDateTime fechaHoraCompleta) {
        this.fechaHoraCompleta = fechaHoraCompleta;
    }

    public String getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(String idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }
}
