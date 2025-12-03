package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Aggregate Root - Solicitud de cotejo masivo
 * Representa el concepto central del dominio de negocio
 */
public class SolicitudCotejoMasivo {
    
    private String solicitudId;
    private String numeroSolicitud;
    private String tipoTramite;
    private LocalDateTime fechaSolicitud;
    private Prioridad prioridad;
    private EstadoSolicitud estado;
    private EntidadSolicitante entidadSolicitante;
    private List<RegistroCotejo> registrosCotejo;
    private ConfiguracionProceso configuracionProceso;
    private DocumentoSolicitud documentoSolicitud;
    private String observaciones;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    private String codigoOficina;
    private String idempotencyKey;
    
    public SolicitudCotejoMasivo() {
        this.solicitudId = UUID.randomUUID().toString();
        this.estado = EstadoSolicitud.BORRADOR;
        this.fechaRegistro = LocalDateTime.now();
    }
    
    // Constructor para crear nueva solicitud
    public SolicitudCotejoMasivo(String numeroSolicitud, String tipoTramite, Prioridad prioridad,
                                  EntidadSolicitante entidadSolicitante, List<RegistroCotejo> registrosCotejo) {
        this();
        this.numeroSolicitud = numeroSolicitud;
        this.tipoTramite = tipoTramite;
        this.fechaSolicitud = LocalDateTime.now();
        this.prioridad = prioridad;
        this.entidadSolicitante = entidadSolicitante;
        this.registrosCotejo = registrosCotejo;
        validar();
    }
    
    // Métodos de negocio
    
    public void registrar(String usuarioRegistro, String codigoOficina, String idempotencyKey) {
        if (this.estado != EstadoSolicitud.BORRADOR) {
            throw new IllegalStateException("Solo se pueden registrar solicitudes en estado BORRADOR");
        }
        this.estado = EstadoSolicitud.REGISTRADA;
        this.usuarioRegistro = usuarioRegistro;
        this.codigoOficina = codigoOficina;
        this.idempotencyKey = idempotencyKey;
        this.fechaRegistro = LocalDateTime.now();
    }
    
    public void iniciarProcesamiento() {
        if (this.estado != EstadoSolicitud.REGISTRADA) {
            throw new IllegalStateException("Solo se pueden procesar solicitudes REGISTRADAS");
        }
        this.estado = EstadoSolicitud.EN_PROCESO;
    }
    
    public void completar() {
        if (this.estado != EstadoSolicitud.EN_PROCESO) {
            throw new IllegalStateException("Solo se pueden completar solicitudes EN_PROCESO");
        }
        this.estado = EstadoSolicitud.COMPLETADA;
    }
    
    public void cancelar() {
        if (this.estado == EstadoSolicitud.COMPLETADA || this.estado == EstadoSolicitud.CANCELADA) {
            throw new IllegalStateException("No se puede cancelar una solicitud COMPLETADA o ya CANCELADA");
        }
        this.estado = EstadoSolicitud.CANCELADA;
    }
    
    public void rechazar(String motivo) {
        if (this.estado == EstadoSolicitud.COMPLETADA) {
            throw new IllegalStateException("No se puede rechazar una solicitud COMPLETADA");
        }
        this.estado = EstadoSolicitud.RECHAZADA;
        this.observaciones = motivo;
    }
    
    public int getTotalRegistros() {
        return registrosCotejo != null ? registrosCotejo.size() : 0;
    }
    
    public boolean esPrioridadAlta() {
        return prioridad == Prioridad.ALTA || prioridad == Prioridad.URGENTE;
    }
    
    public boolean puedeSerCancelada() {
        return estado != EstadoSolicitud.COMPLETADA && estado != EstadoSolicitud.CANCELADA;
    }
    
    // Validaciones de negocio
    
    private void validar() {
        if (registrosCotejo == null || registrosCotejo.isEmpty()) {
            throw new IllegalArgumentException("La solicitud debe contener al menos un registro");
        }
        if (registrosCotejo.size() > 10000) {
            throw new IllegalArgumentException("La solicitud no puede contener más de 10,000 registros");
        }
        if (entidadSolicitante == null) {
            throw new IllegalArgumentException("Debe especificar la entidad solicitante");
        }
    }
    
    // Getters y Setters
    
    public String getSolicitudId() {
        return solicitudId;
    }
    
    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }
    
    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }
    
    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }
    
    public String getTipoTramite() {
        return tipoTramite;
    }
    
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }
    
    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }
    
    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    
    public Prioridad getPrioridad() {
        return prioridad;
    }
    
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
    
    public EstadoSolicitud getEstado() {
        return estado;
    }
    
    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }
    
    public EntidadSolicitante getEntidadSolicitante() {
        return entidadSolicitante;
    }
    
    public void setEntidadSolicitante(EntidadSolicitante entidadSolicitante) {
        this.entidadSolicitante = entidadSolicitante;
    }
    
    public List<RegistroCotejo> getRegistrosCotejo() {
        return registrosCotejo;
    }
    
    public void setRegistrosCotejo(List<RegistroCotejo> registrosCotejo) {
        this.registrosCotejo = registrosCotejo;
    }
    
    public ConfiguracionProceso getConfiguracionProceso() {
        return configuracionProceso;
    }
    
    public void setConfiguracionProceso(ConfiguracionProceso configuracionProceso) {
        this.configuracionProceso = configuracionProceso;
    }
    
    public DocumentoSolicitud getDocumentoSolicitud() {
        return documentoSolicitud;
    }
    
    public void setDocumentoSolicitud(DocumentoSolicitud documentoSolicitud) {
        this.documentoSolicitud = documentoSolicitud;
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
    
    public String getCodigoOficina() {
        return codigoOficina;
    }
    
    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }
    
    public String getIdempotencyKey() {
        return idempotencyKey;
    }
    
    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }
}
