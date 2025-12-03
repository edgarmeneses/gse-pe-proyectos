package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExcepcionHorariaEntity {
    private String idExcepcion;
    private String codigoSede;
    private String nombreSede;
    private LocalDate fechaExcepcion;
    private String tipoExcepcion;
    private String descripcion;
    private String horarioEspecialHoraInicio;
    private String horarioEspecialHoraFin;
    private Integer horarioEspecialCapacidadPorFranja;
    private Boolean afectaCitasExistentes;
    private Boolean notificarAfectados;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;

    public ExcepcionHorariaEntity() {
    }

    public String getIdExcepcion() {
        return idExcepcion;
    }

    public void setIdExcepcion(String idExcepcion) {
        this.idExcepcion = idExcepcion;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public LocalDate getFechaExcepcion() {
        return fechaExcepcion;
    }

    public void setFechaExcepcion(LocalDate fechaExcepcion) {
        this.fechaExcepcion = fechaExcepcion;
    }

    public String getTipoExcepcion() {
        return tipoExcepcion;
    }

    public void setTipoExcepcion(String tipoExcepcion) {
        this.tipoExcepcion = tipoExcepcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorarioEspecialHoraInicio() {
        return horarioEspecialHoraInicio;
    }

    public void setHorarioEspecialHoraInicio(String horarioEspecialHoraInicio) {
        this.horarioEspecialHoraInicio = horarioEspecialHoraInicio;
    }

    public String getHorarioEspecialHoraFin() {
        return horarioEspecialHoraFin;
    }

    public void setHorarioEspecialHoraFin(String horarioEspecialHoraFin) {
        this.horarioEspecialHoraFin = horarioEspecialHoraFin;
    }

    public Integer getHorarioEspecialCapacidadPorFranja() {
        return horarioEspecialCapacidadPorFranja;
    }

    public void setHorarioEspecialCapacidadPorFranja(Integer horarioEspecialCapacidadPorFranja) {
        this.horarioEspecialCapacidadPorFranja = horarioEspecialCapacidadPorFranja;
    }

    public Boolean getAfectaCitasExistentes() {
        return afectaCitasExistentes;
    }

    public void setAfectaCitasExistentes(Boolean afectaCitasExistentes) {
        this.afectaCitasExistentes = afectaCitasExistentes;
    }

    public Boolean getNotificarAfectados() {
        return notificarAfectados;
    }

    public void setNotificarAfectados(Boolean notificarAfectados) {
        this.notificarAfectados = notificarAfectados;
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
}
