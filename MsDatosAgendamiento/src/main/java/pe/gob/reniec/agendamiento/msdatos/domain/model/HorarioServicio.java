package pe.gob.reniec.agendamiento.msdatos.domain.model;

public class HorarioServicio {
    private Integer diaSemana;
    private String nombreDia;
    private String horaInicio;
    private String horaFin;
    private Integer capacidadPorFranja;
    private Integer duracionFranjaMinutos;
    private Boolean activo;

    public HorarioServicio() {
    }

    public HorarioServicio(Integer diaSemana, String nombreDia, String horaInicio, String horaFin,
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

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
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

    public Integer getDuracionFranjaMinutos() {
        return duracionFranjaMinutos;
    }

    public void setDuracionFranjaMinutos(Integer duracionFranjaMinutos) {
        this.duracionFranjaMinutos = duracionFranjaMinutos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
