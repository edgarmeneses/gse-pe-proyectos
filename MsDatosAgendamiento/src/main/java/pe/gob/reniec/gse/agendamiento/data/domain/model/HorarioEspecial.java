package pe.gob.reniec.gse.agendamiento.data.domain.model;

import java.time.LocalTime;

public class HorarioEspecial {
    
    private final LocalTime horaInicio;
    private final LocalTime horaFin;
    private final Integer capacidadPorFranja;
    
    public HorarioEspecial(LocalTime horaInicio, LocalTime horaFin, Integer capacidadPorFranja) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.capacidadPorFranja = capacidadPorFranja;
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
}
