package pe.gob.reniec.gse.agendamiento.data.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Cita {
    
    private static final int MAXIMO_REAGENDAMIENTOS_DEFAULT = 3;
    private static final int HORAS_LIMITE_REAGENDAMIENTO = 48;
    
    private String citaId;
    private String codigoCita;
    private EstadoCita estado;
    private SedeServicio sedeServicio;
    private Solicitud solicitud;
    private Solicitante solicitante;
    private Programacion programacion;
    private TecnicoAsignado tecnicoAsignado;
    private String tokenReagendamiento;
    private LocalDateTime fechaLimiteReagendamiento;
    private Integer cantidadReagendamientos;
    private Integer maximoReagendamientos;
    private String observaciones;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    private LocalDateTime fechaActualizacion;
    private String usuarioActualizacion;
    
    public Cita() {
        this.cantidadReagendamientos = 0;
        this.maximoReagendamientos = MAXIMO_REAGENDAMIENTOS_DEFAULT;
        this.estado = EstadoCita.PENDIENTE;
    }
    
    public Cita(String citaId, String codigoCita, EstadoCita estado, SedeServicio sedeServicio,
                Solicitud solicitud, Solicitante solicitante, Programacion programacion,
                TecnicoAsignado tecnicoAsignado, String tokenReagendamiento,
                LocalDateTime fechaLimiteReagendamiento, Integer cantidadReagendamientos,
                Integer maximoReagendamientos, String observaciones, LocalDateTime fechaRegistro,
                String usuarioRegistro, LocalDateTime fechaActualizacion, String usuarioActualizacion) {
        this.citaId = citaId;
        this.codigoCita = codigoCita;
        this.estado = estado;
        this.sedeServicio = sedeServicio;
        this.solicitud = solicitud;
        this.solicitante = solicitante;
        this.programacion = programacion;
        this.tecnicoAsignado = tecnicoAsignado;
        this.tokenReagendamiento = tokenReagendamiento;
        this.fechaLimiteReagendamiento = fechaLimiteReagendamiento;
        this.cantidadReagendamientos = cantidadReagendamientos != null ? cantidadReagendamientos : 0;
        this.maximoReagendamientos = maximoReagendamientos != null ? maximoReagendamientos : MAXIMO_REAGENDAMIENTOS_DEFAULT;
        this.observaciones = observaciones;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaActualizacion = fechaActualizacion;
        this.usuarioActualizacion = usuarioActualizacion;
    }
    
    public void crear(SedeServicio sedeServicio, Solicitud solicitud, Solicitante solicitante,
                     Programacion programacion, String usuarioCreador) {
        validarDatosObligatorios(sedeServicio, solicitud, solicitante, programacion);
        
        if (programacion.esEnElPasado()) {
            throw new IllegalStateException("No se puede crear una cita en el pasado");
        }
        
        this.citaId = UUID.randomUUID().toString();
        this.codigoCita = generarCodigoCita();
        this.estado = EstadoCita.PENDIENTE;
        this.sedeServicio = sedeServicio;
        this.solicitud = solicitud;
        this.solicitante = solicitante;
        this.programacion = programacion;
        this.tokenReagendamiento = generarToken();
        this.fechaLimiteReagendamiento = calcularFechaLimiteReagendamiento();
        this.cantidadReagendamientos = 0;
        this.maximoReagendamientos = MAXIMO_REAGENDAMIENTOS_DEFAULT;
        this.fechaRegistro = LocalDateTime.now();
        this.usuarioRegistro = usuarioCreador;
    }
    
    public void reagendar(Programacion nuevaProgramacion, String motivoCambio, String usuario) {
        if (!puedeReagendar()) {
            throw new IllegalStateException("La cita no puede ser reagendada. Estado: " + estado.getNombre());
        }
        
        if (cantidadReagendamientos >= maximoReagendamientos) {
            throw new IllegalStateException("Se ha alcanzado el máximo de reagendamientos permitidos");
        }
        
        if (!estaEnPlazoParaReagendar()) {
            throw new IllegalStateException("Ha expirado el plazo para reagendar la cita");
        }
        
        if (nuevaProgramacion.esEnElPasado()) {
            throw new IllegalStateException("No se puede reagendar a una fecha en el pasado");
        }
        
        this.programacion = nuevaProgramacion;
        this.estado = EstadoCita.REAGENDADA;
        this.cantidadReagendamientos++;
        this.tokenReagendamiento = generarToken();
        this.fechaLimiteReagendamiento = calcularFechaLimiteReagendamiento();
        this.observaciones = (this.observaciones != null ? this.observaciones + " | " : "") + motivoCambio;
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public void cancelar(String motivoCancelacion, String usuario) {
        if (!estado.permiteCancelacion()) {
            throw new IllegalStateException("La cita no puede ser cancelada. Estado: " + estado.getNombre());
        }
        
        this.estado = EstadoCita.CANCELADA;
        this.observaciones = (this.observaciones != null ? this.observaciones + " | " : "") + "Cancelación: " + motivoCancelacion;
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public void confirmar(String usuario) {
        if (estado != EstadoCita.PENDIENTE && estado != EstadoCita.REAGENDADA) {
            throw new IllegalStateException("Solo se pueden confirmar citas pendientes o reagendadas");
        }
        
        this.estado = EstadoCita.CONFIRMADA;
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public void completar(String usuario) {
        if (!estado.esActiva() && estado != EstadoCita.REAGENDADA) {
            throw new IllegalStateException("Solo se pueden completar citas activas");
        }
        
        this.estado = EstadoCita.COMPLETADA;
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public void marcarNoAsistio(String usuario) {
        if (!estado.esActiva() && estado != EstadoCita.REAGENDADA) {
            throw new IllegalStateException("Solo se puede marcar no asistió en citas activas");
        }
        
        if (programacion.esEnElFuturo()) {
            throw new IllegalStateException("No se puede marcar no asistió para una cita futura");
        }
        
        this.estado = EstadoCita.NO_ASISTIO;
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public void asignarTecnico(TecnicoAsignado tecnico, String usuario) {
        if (estado.esFinalizada()) {
            throw new IllegalStateException("No se puede asignar técnico a una cita finalizada");
        }
        
        this.tecnicoAsignado = tecnico;
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public boolean puedeReagendar() {
        return estado.permiteReagendamiento() && cantidadReagendamientos < maximoReagendamientos;
    }
    
    public boolean estaEnPlazoParaReagendar() {
        return LocalDateTime.now().isBefore(fechaLimiteReagendamiento);
    }
    
    public boolean esActiva() {
        return estado.esActiva();
    }
    
    public boolean estaFinalizada() {
        return estado.esFinalizada();
    }
    
    public int reagendamientosDisponibles() {
        return maximoReagendamientos - cantidadReagendamientos;
    }
    
    private void validarDatosObligatorios(SedeServicio sedeServicio, Solicitud solicitud,
                                         Solicitante solicitante, Programacion programacion) {
        if (sedeServicio == null) {
            throw new IllegalArgumentException("La sede de servicio es requerida");
        }
        if (solicitud == null) {
            throw new IllegalArgumentException("La solicitud es requerida");
        }
        if (solicitante == null) {
            throw new IllegalArgumentException("El solicitante es requerido");
        }
        if (programacion == null) {
            throw new IllegalArgumentException("La programación es requerida");
        }
    }
    
    private String generarCodigoCita() {
        return "CITA-" + System.currentTimeMillis();
    }
    
    private String generarToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    private LocalDateTime calcularFechaLimiteReagendamiento() {
        return programacion.getFechaHoraCompleta().minusHours(HORAS_LIMITE_REAGENDAMIENTO);
    }
    
    // Getters y Setters
    
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
    
    public Integer getMaximoReagendamientos() {
        return maximoReagendamientos;
    }
    
    public void setMaximoReagendamientos(Integer maximoReagendamientos) {
        this.maximoReagendamientos = maximoReagendamientos;
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
