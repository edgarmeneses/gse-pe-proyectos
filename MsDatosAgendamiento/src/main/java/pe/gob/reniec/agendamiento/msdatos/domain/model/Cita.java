package pe.gob.reniec.agendamiento.msdatos.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Cita - Aggregate Root
 * Representa una cita programada para visita de lectura de documento archivado.
 * Mantiene la invariante de negocio: una cita tiene un estado válido en su ciclo de vida.
 */
public class Cita {
    // Identidad
    private String citaId;
    private String codigoCita;
    
    // Estado del agregado
    private EstadoCita estado;
    
    // Entidades y Value Objects
    private SedeServicio sedeServicio;
    private Solicitud solicitud;
    private Solicitante solicitante;
    private Programacion programacion;
    private TecnicoAsignado tecnicoAsignado;
    
    // Capacidades de reagendamiento
    private String tokenReagendamiento;
    private LocalDateTime fechaLimiteReagendamiento;
    private Integer cantidadReagendamientos;
    
    // Observaciones
    private String observaciones;
    
    // Auditoría (para trazabilidad, no son parte del comportamiento del dominio)
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    private LocalDateTime fechaActualizacion;
    private String usuarioActualizacion;
    
    // Historial de cambios (para auditoría completa)
    private List<HistorialCambio> historial;

    // Constructores
    public Cita() {
        this.historial = new ArrayList<>();
        this.cantidadReagendamientos = 0;
    }

    // Factory method para crear nueva cita
    public static Cita crearNueva(SedeServicio sedeServicio, Solicitud solicitud, 
                                  Solicitante solicitante, Programacion programacion,
                                  TecnicoAsignado tecnicoAsignado, String observaciones,
                                  String usuarioCreador) {
        Cita cita = new Cita();
        cita.citaId = UUID.randomUUID().toString();
        cita.codigoCita = generarCodigoCita();
        cita.estado = new EstadoCita("PROGRAMADA", "Cita programada");
        cita.sedeServicio = sedeServicio;
        cita.solicitud = solicitud;
        cita.solicitante = solicitante;
        cita.programacion = programacion;
        cita.tecnicoAsignado = tecnicoAsignado;
        cita.observaciones = observaciones;
        cita.tokenReagendamiento = UUID.randomUUID().toString();
        cita.fechaLimiteReagendamiento = programacion.getFechaCita().minusHours(24);
        cita.cantidadReagendamientos = 0;
        cita.fechaRegistro = LocalDateTime.now();
        cita.usuarioRegistro = usuarioCreador;
        return cita;
    }

    // Métodos de negocio
    public void reagendar(Programacion nuevaProgramacion, TecnicoAsignado nuevoTecnico, 
                          String motivoCambio, String usuario) {
        if (!puedeReagendar()) {
            throw new IllegalStateException("La cita no puede ser reagendada");
        }
        
        registrarCambio("PROGRAMACION", this.programacion.toString(), 
                       nuevaProgramacion.toString(), motivoCambio, usuario);
        
        this.programacion = nuevaProgramacion;
        if (nuevoTecnico != null) {
            this.tecnicoAsignado = nuevoTecnico;
        }
        this.cantidadReagendamientos++;
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }

    public void cancelar(String motivo, String usuario) {
        if (!puedeCancelar()) {
            throw new IllegalStateException("La cita no puede ser cancelada en su estado actual");
        }
        
        registrarCambio("ESTADO", this.estado.getCodigo(), "CANCELADA", motivo, usuario);
        this.estado = new EstadoCita("CANCELADA", "Cita cancelada");
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }

    public void completar(String usuario) {
        if (!"PROGRAMADA".equals(this.estado.getCodigo())) {
            throw new IllegalStateException("Solo citas programadas pueden completarse");
        }
        
        registrarCambio("ESTADO", this.estado.getCodigo(), "COMPLETADA", 
                       "Cita completada", usuario);
        this.estado = new EstadoCita("COMPLETADA", "Cita completada");
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }

    // Invariantes de negocio
    public boolean puedeReagendar() {
        return "PROGRAMADA".equals(this.estado.getCodigo()) 
               && LocalDateTime.now().isBefore(this.fechaLimiteReagendamiento);
    }

    public boolean puedeCancelar() {
        return "PROGRAMADA".equals(this.estado.getCodigo());
    }

    // Métodos de consulta
    public List<HistorialCambio> getHistorial() {
        return Collections.unmodifiableList(historial);
    }

    public void agregarHistorial(HistorialCambio cambio) {
        if (this.historial == null) {
            this.historial = new ArrayList<>();
        }
        this.historial.add(cambio);
    }

    // Métodos privados
    private void registrarCambio(String campo, String valorAnterior, String valorNuevo, 
                                 String motivo, String usuario) {
        HistorialCambio cambio = new HistorialCambio(
            UUID.randomUUID().toString(),
            LocalDateTime.now(),
            campo,
            valorAnterior,
            valorNuevo,
            motivo,
            usuario
        );
        agregarHistorial(cambio);
    }

    private static String generarCodigoCita() {
        return "CIT-" + System.currentTimeMillis();
    }

    public String getCitaId() {
        return citaId;
    }

    public void setCitaId(String citaId) {
        this.citaId = citaId;
    }

    public String getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(String codigoCita) {
        this.codigoCita = codigoCita;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public SedeServicio getSedeServicio() {
        return sedeServicio;
    }

    public void setSedeServicio(SedeServicio sedeServicio) {
        this.sedeServicio = sedeServicio;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    public TecnicoAsignado getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(TecnicoAsignado tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public String getTokenReagendamiento() {
        return tokenReagendamiento;
    }

    public void setTokenReagendamiento(String tokenReagendamiento) {
        this.tokenReagendamiento = tokenReagendamiento;
    }

    public LocalDateTime getFechaLimiteReagendamiento() {
        return fechaLimiteReagendamiento;
    }

    public void setFechaLimiteReagendamiento(LocalDateTime fechaLimiteReagendamiento) {
        this.fechaLimiteReagendamiento = fechaLimiteReagendamiento;
    }

    private static String generarCodigoCita() {
        return "CIT-" + System.currentTimeMillis();
    }

    // Getters (sin setters para mantener encapsulamiento)
    public String getCitaId() {
        return citaId;
    }

    public void setCitaId(String citaId) {
        this.citaId = citaId;
    }

    public String getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(String codigoCita) {
        this.codigoCita = codigoCita;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public SedeServicio getSedeServicio() {
        return sedeServicio;
    }

    public void setSedeServicio(SedeServicio sedeServicio) {
        this.sedeServicio = sedeServicio;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    public TecnicoAsignado getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(TecnicoAsignado tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public String getTokenReagendamiento() {
        return tokenReagendamiento;
    }

    public void setTokenReagendamiento(String tokenReagendamiento) {
        this.tokenReagendamiento = tokenReagendamiento;
    }

    public LocalDateTime getFechaLimiteReagendamiento() {
        return fechaLimiteReagendamiento;
    }

    public void setFechaLimiteReagendamiento(LocalDateTime fechaLimiteReagendamiento) {
        this.fechaLimiteReagendamiento = fechaLimiteReagendamiento;
    }

    public Integer getCantidadReagendamientos() {
        return cantidadReagendamientos;
    }

    public void setCantidadReagendamientos(Integer cantidadReagendamientos) {
        this.cantidadReagendamientos = cantidadReagendamientos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }
}
