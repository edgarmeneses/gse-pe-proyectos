package pe.gob.reniec.gse.agendamiento.data.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ExcepcionHoraria {
    
    private String idExcepcion;
    private CodigoSede codigoSede;
    private LocalDate fechaExcepcion;
    private TipoExcepcion tipoExcepcion;
    private String descripcion;
    private HorarioEspecial horarioEspecial;
    private Boolean afectaCitasExistentes;
    private Boolean notificarAfectados;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    
    public ExcepcionHoraria() {
        this.afectaCitasExistentes = false;
        this.notificarAfectados = true;
    }
    
    public ExcepcionHoraria(String idExcepcion, CodigoSede codigoSede, LocalDate fechaExcepcion,
                           TipoExcepcion tipoExcepcion, String descripcion, HorarioEspecial horarioEspecial,
                           Boolean afectaCitasExistentes, Boolean notificarAfectados,
                           LocalDateTime fechaRegistro, String usuarioRegistro) {
        this.idExcepcion = idExcepcion;
        this.codigoSede = codigoSede;
        this.fechaExcepcion = fechaExcepcion;
        this.tipoExcepcion = tipoExcepcion;
        this.descripcion = descripcion;
        this.horarioEspecial = horarioEspecial;
        this.afectaCitasExistentes = afectaCitasExistentes != null ? afectaCitasExistentes : false;
        this.notificarAfectados = notificarAfectados != null ? notificarAfectados : true;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }
    
    public void registrar(CodigoSede codigoSede, LocalDate fechaExcepcion, TipoExcepcion tipoExcepcion,
                         String descripcion, HorarioEspecial horarioEspecial, String usuario) {
        validarDatosObligatorios(codigoSede, fechaExcepcion, tipoExcepcion, descripcion);
        
        if (fechaExcepcion.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("No se puede registrar excepción en el pasado");
        }
        
        this.idExcepcion = UUID.randomUUID().toString();
        this.codigoSede = codigoSede;
        this.fechaExcepcion = fechaExcepcion;
        this.tipoExcepcion = tipoExcepcion;
        this.descripcion = descripcion.trim();
        this.horarioEspecial = horarioEspecial;
        this.afectaCitasExistentes = tipoExcepcion.requiereCancelacionCitas();
        this.notificarAfectados = true;
        this.fechaRegistro = LocalDateTime.now();
        this.usuarioRegistro = usuario;
    }
    
    public boolean requiereCancelacionDeCitas() {
        return tipoExcepcion.requiereCancelacionCitas() && afectaCitasExistentes;
    }
    
    public boolean esParaLaSede(CodigoSede codigoSede) {
        return this.codigoSede.equals(codigoSede);
    }
    
    public boolean esParaLaFecha(LocalDate fecha) {
        return this.fechaExcepcion.equals(fecha);
    }
    
    public boolean tieneHorarioEspecial() {
        return horarioEspecial != null;
    }
    
    private void validarDatosObligatorios(CodigoSede codigoSede, LocalDate fechaExcepcion,
                                         TipoExcepcion tipoExcepcion, String descripcion) {
        if (codigoSede == null) {
            throw new IllegalArgumentException("El código de sede es requerido");
        }
        if (fechaExcepcion == null) {
            throw new IllegalArgumentException("La fecha de excepción es requerida");
        }
        if (tipoExcepcion == null) {
            throw new IllegalArgumentException("El tipo de excepción es requerido");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción es requerida");
        }
    }
    
    // Getters y Setters
    
    public String getIdExcepcion() {
        return idExcepcion;
    }
    
    public void setIdExcepcion(String idExcepcion) {
        this.idExcepcion = idExcepcion;
    }
    
    public CodigoSede getCodigoSede() {
        return codigoSede;
    }
    
    public void setCodigoSede(CodigoSede codigoSede) {
        this.codigoSede = codigoSede;
    }
    
    public LocalDate getFechaExcepcion() {
        return fechaExcepcion;
    }
    
    public void setFechaExcepcion(LocalDate fechaExcepcion) {
        this.fechaExcepcion = fechaExcepcion;
    }
    
    public TipoExcepcion getTipoExcepcion() {
        return tipoExcepcion;
    }
    
    public void setTipoExcepcion(TipoExcepcion tipoExcepcion) {
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
