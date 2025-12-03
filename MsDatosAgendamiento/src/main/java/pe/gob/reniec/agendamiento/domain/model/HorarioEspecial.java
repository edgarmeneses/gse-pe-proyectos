package pe.gob.reniec.agendamiento.domain.model;

import java.time.LocalTime;

public class HorarioEspecial {
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long capacidadPorFranja;

    public HorarioEspecial() {
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
}
