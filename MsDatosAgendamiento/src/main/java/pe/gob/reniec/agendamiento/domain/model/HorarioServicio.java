package pe.gob.reniec.agendamiento.domain.model;

import java.time.LocalTime;

public class HorarioServicio {
    private Long diaSemana;
    private String nombreDia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long capacidadPorFranja;
    private Long duracionFranjaMinutos;
    private Boolean activo;

    public HorarioServicio() {
    }

    public Long getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Long diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
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

    public Long getCapacidadPorFranja() {
        return capacidadPorFranja;
    }

    public void setCapacidadPorFranja(Long capacidadPorFranja) {
        this.capacidadPorFranja = capacidadPorFranja;
    }

    public Long getDuracionFranjaMinutos() {
        return duracionFranjaMinutos;
    }

    public void setDuracionFranjaMinutos(Long duracionFranjaMinutos) {
        this.duracionFranjaMinutos = duracionFranjaMinutos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
