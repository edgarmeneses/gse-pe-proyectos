package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;

public class DisponibilidadEntity {
    private String idDisponibilidad;
    private String codigoSede;
    private LocalDate fecha;
    private String diaSemana;
    private Boolean esHabil;
    private String motivoNoHabil;
    private String horaInicio;
    private String horaFin;
    private Integer capacidadTotal;
    private Integer capacidadOcupada;
    private Integer capacidadDisponible;
    private String estado;

    public DisponibilidadEntity() {
    }

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

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
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
}
