package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ExcepcionHorariaEntity {
    
    private String idExcepcion;
    private String codigoSede;
    private LocalDate fechaExcepcion;
    private String tipoExcepcion;
    private String descripcion;
    private LocalTime horaInicioEspecial;
    private LocalTime horaFinEspecial;
    private Integer capacidadPorFranjaEspecial;
    private Boolean afectaCitasExistentes;
    private Boolean notificarAfectados;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    
    public ExcepcionHorariaEntity() {
    }
    
    // Getters y Setters
    
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
    
    public LocalTime getHoraInicioEspecial() {
        return horaInicioEspecial;
    }
    
    public void setHoraInicioEspecial(LocalTime horaInicioEspecial) {
        this.horaInicioEspecial = horaInicioEspecial;
    }
    
    public LocalTime getHoraFinEspecial() {
        return horaFinEspecial;
    }
    
    public void setHoraFinEspecial(LocalTime horaFinEspecial) {
        this.horaFinEspecial = horaFinEspecial;
    }
    
    public Integer getCapacidadPorFranjaEspecial() {
        return capacidadPorFranjaEspecial;
    }
    
    public void setCapacidadPorFranjaEspecial(Integer capacidadPorFranjaEspecial) {
        this.capacidadPorFranjaEspecial = capacidadPorFranjaEspecial;
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
