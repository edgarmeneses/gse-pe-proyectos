package pe.gob.reniec.agendamiento.msdatos.domain.model;

import java.time.LocalDateTime;

public class Programacion {
    private LocalDateTime fechaCita;
    private String horaCita;
    private LocalDateTime fechaHoraCompleta;
    private String idDisponibilidad;

    public Programacion() {
    }

    public Programacion(LocalDateTime fechaCita, String horaCita, LocalDateTime fechaHoraCompleta, String idDisponibilidad) {
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.fechaHoraCompleta = fechaHoraCompleta;
        this.idDisponibilidad = idDisponibilidad;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
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
