package pe.gob.reniec.agendamiento.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;

public class ExcepcionHoraria {
    private String idExcepcion;
    private String codigoSede;
    private String nombreSede;
    private LocalDate fechaExcepcion;
    private String tipoExcepcion;
    private String descripcion;
    private HorarioEspecial horarioEspecial;
    private Boolean afectaCitasExistentes;
    private Boolean notificarAfectados;
    private CitasAfectadas citasAfectadas;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;

    public ExcepcionHoraria() {
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

    public HorarioEspecial getHorarioEspecial() {
        return horarioEspecial;
    }

    public void setHorarioEspecial(HorarioEspecial horarioEspecial) {
        this.horarioEspecial = horarioEspecial;
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

    public CitasAfectadas getCitasAfectadas() {
        return citasAfectadas;
    }

    public void setCitasAfectadas(CitasAfectadas citasAfectadas) {
        this.citasAfectadas = citasAfectadas;
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
