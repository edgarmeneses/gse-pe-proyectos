package pe.gob.reniec.agendamiento.msdatos.domain.model;

public class HorarioEspecial {
    private String horaInicio;
    private String horaFin;
    private Integer capacidadPorFranja;

    public HorarioEspecial() {
    }

    public HorarioEspecial(String horaInicio, String horaFin, Integer capacidadPorFranja) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.capacidadPorFranja = capacidadPorFranja;
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

    public Integer getCapacidadPorFranja() {
        return capacidadPorFranja;
    }

    public void setCapacidadPorFranja(Integer capacidadPorFranja) {
        this.capacidadPorFranja = capacidadPorFranja;
    }
}
