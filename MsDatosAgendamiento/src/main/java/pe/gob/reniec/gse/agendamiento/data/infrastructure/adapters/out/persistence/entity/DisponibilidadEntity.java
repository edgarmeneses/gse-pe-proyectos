package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DisponibilidadEntity {
    
    private String idDisponibilidad;
    private String codigoSede;
    private LocalDate fecha;
    private String diaSemana;
    private Boolean esHabil;
    private String motivoNoHabil;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer capacidadTotal;
    private Integer capacidadOcupada;
    private Integer capacidadDisponible;
    private String estado;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    private LocalDateTime fechaActualizacion;
    private String usuarioActualizacion;
    
    public DisponibilidadEntity() {
    }
    
    // Getters y Setters
    
    public String getIdDisponibilidad() {
        return idDisponibilidad;
    }
    
    public void setIdDisponibilidad(String idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }
    
    public String getCodigoSede() {
        return codigoSede;
    }
    
    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
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
    
    public Integer getCapacidadTotal() {
        return capacidadTotal;
    }
    
    public void setCapacidadTotal(Integer capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }
    
    public Integer getCapacidadOcupada() {
        return capacidadOcupada;
    }
    
    public void setCapacidadOcupada(Integer capacidadOcupada) {
        this.capacidadOcupada = capacidadOcupada;
    }
    
    public Integer getCapacidadDisponible() {
        return capacidadDisponible;
    }
    
    public void setCapacidadDisponible(Integer capacidadDisponible) {
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
