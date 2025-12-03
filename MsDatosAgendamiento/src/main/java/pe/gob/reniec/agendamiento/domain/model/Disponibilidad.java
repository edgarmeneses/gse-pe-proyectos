package pe.gob.reniec.agendamiento.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;

public class Disponibilidad {
    private String idDisponibilidad;
    private SedeServicio sedeServicio;
    private LocalDate fecha;
    private String diaSemana;
    private Boolean esHabil;
    private String motivoNoHabil;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long capacidadTotal;
    private Long capacidadOcupada;
    private Long capacidadDisponible;
    private String estado;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    private LocalDateTime fechaActualizacion;
    private String usuarioActualizacion;

    public Disponibilidad() {
    }

    public String getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(String idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public SedeServicio getSedeServicio() {
        return sedeServicio;
    }

    public void setSedeServicio(SedeServicio sedeServicio) {
        this.sedeServicio = sedeServicio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Boolean getEsHabil() {
        return esHabil;
    }

    public void setEsHabil(Boolean esHabil) {
        this.esHabil = esHabil;
    }

    public String getMotivoNoHabil() {
        return motivoNoHabil;
    }

    public void setMotivoNoHabil(String motivoNoHabil) {
        this.motivoNoHabil = motivoNoHabil;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Long getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(Long capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public Long getCapacidadOcupada() {
        return capacidadOcupada;
    }

    public void setCapacidadOcupada(Long capacidadOcupada) {
        this.capacidadOcupada = capacidadOcupada;
    }

    public Long getCapacidadDisponible() {
        return capacidadDisponible;
    }

    public void setCapacidadDisponible(Long capacidadDisponible) {
        this.capacidadDisponible = capacidadDisponible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }
}
