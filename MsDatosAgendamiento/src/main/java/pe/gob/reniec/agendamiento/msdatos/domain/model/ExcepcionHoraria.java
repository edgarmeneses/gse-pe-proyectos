package pe.gob.reniec.agendamiento.msdatos.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * ExcepcionHoraria - Aggregate Root
 * Representa una excepción a la disponibilidad normal de una sede en una fecha específica.
 * Puede ser un feriado, un cambio de horario, o un cierre temporal.
 */
public class ExcepcionHoraria {
    // Identidad
    private String excepcionId;
    
    // Datos básicos
    private String codigoSede;
    private String codigoServicio;
    private LocalDate fecha;
    
    // Tipo de excepción: FERIADO, CAMBIO_HORARIO, CIERRE_TEMPORAL
    private String tipo;
    private String motivo;
    
    // Horario especial (solo si tipo es CAMBIO_HORARIO)
    private HorarioEspecial horarioEspecial;
    
    // Observaciones adicionales
    private String observaciones;
    
    // Auditoría
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;

    // Constructores
    public ExcepcionHoraria() {
    }

    public ExcepcionHoraria(String excepcionId, String codigoSede, String codigoServicio,
                            LocalDate fecha, String tipo, String motivo,
                            HorarioEspecial horarioEspecial, String observaciones,
                            LocalDateTime fechaCreacion, String usuarioCreacion) {
        this.excepcionId = excepcionId;
        this.codigoSede = codigoSede;
        this.codigoServicio = codigoServicio;
        this.fecha = fecha;
        this.tipo = tipo;
        this.motivo = motivo;
        this.horarioEspecial = horarioEspecial;
        this.observaciones = observaciones;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
    }

    // Factory methods
    public static ExcepcionHoraria crearFeriado(String codigoSede, String codigoServicio,
                                                 LocalDate fecha, String motivo,
                                                 String usuario) {
        ExcepcionHoraria excepcion = new ExcepcionHoraria();
        excepcion.excepcionId = UUID.randomUUID().toString();
        excepcion.codigoSede = codigoSede;
        excepcion.codigoServicio = codigoServicio;
        excepcion.fecha = fecha;
        excepcion.tipo = "FERIADO";
        excepcion.motivo = motivo;
        excepcion.fechaCreacion = LocalDateTime.now();
        excepcion.usuarioCreacion = usuario;
        return excepcion;
    }

    public static ExcepcionHoraria crearCambioHorario(String codigoSede, String codigoServicio,
                                                       LocalDate fecha, String motivo,
                                                       HorarioEspecial horarioEspecial,
                                                       String usuario) {
        ExcepcionHoraria excepcion = new ExcepcionHoraria();
        excepcion.excepcionId = UUID.randomUUID().toString();
        excepcion.codigoSede = codigoSede;
        excepcion.codigoServicio = codigoServicio;
        excepcion.fecha = fecha;
        excepcion.tipo = "CAMBIO_HORARIO";
        excepcion.motivo = motivo;
        excepcion.horarioEspecial = horarioEspecial;
        excepcion.fechaCreacion = LocalDateTime.now();
        excepcion.usuarioCreacion = usuario;
        return excepcion;
    }

    // Métodos de negocio
    public boolean afectaServicio() {
        return "FERIADO".equals(tipo) || "CIERRE_TEMPORAL".equals(tipo);
    }

    public boolean tieneCambioHorario() {
        return "CAMBIO_HORARIO".equals(tipo) && horarioEspecial != null;
    }
    }
    // Métodos de negocio
    public boolean afectaServicio() {
        return "FERIADO".equals(tipo) || "CIERRE_TEMPORAL".equals(tipo);
    }

    public boolean tieneCambioHorario() {
        return "CAMBIO_HORARIO".equals(tipo) && horarioEspecial != null;
    }

    // Getters y setters
    public String getExcepcionId() {
        return excepcionId;
    }

    public void setExcepcionId(String excepcionId) {
        this.excepcionId = excepcionId;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public HorarioEspecial getHorarioEspecial() {
        return horarioEspecial;
    }

    public void setHorarioEspecial(HorarioEspecial horarioEspecial) {
        this.horarioEspecial = horarioEspecial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
}
