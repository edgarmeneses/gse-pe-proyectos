package pe.gob.reniec.gse.agendamiento.data.domain.model;

import java.time.LocalTime;

public class HorarioServicio {
    
    private final Integer diaSemana;
    private final String nombreDia;
    private final LocalTime horaInicio;
    private final LocalTime horaFin;
    private final Integer capacidadPorFranja;
    private final Integer duracionFranjaMinutos;
    private final Boolean activo;
    
    public HorarioServicio(Integer diaSemana, String nombreDia, LocalTime horaInicio, LocalTime horaFin,
                          Integer capacidadPorFranja, Integer duracionFranjaMinutos, Boolean activo) {
        this.diaSemana = diaSemana;
        this.nombreDia = nombreDia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.capacidadPorFranja = capacidadPorFranja;
        this.duracionFranjaMinutos = duracionFranjaMinutos;
        this.activo = activo;
    }
    
    public Integer getDiaSemana() {
        return diaSemana;
    }
    
    public String getNombreDia() {
        return nombreDia;
    }
    
    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    
    public LocalTime getHoraFin() {
        return horaFin;
    }
    
    public Integer getCapacidadPorFranja() {
        return capacidadPorFranja;
    }
    
    public Integer getDuracionFranjaMinutos() {
        return duracionFranjaMinutos;
    }
    
    public Boolean getActivo() {
        return activo;
    }
}
