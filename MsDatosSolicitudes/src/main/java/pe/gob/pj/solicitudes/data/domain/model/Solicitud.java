package pe.gob.pj.solicitudes.data.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Aggregate Root: Solicitud
 * Representa una solicitud de trámite en el sistema
 */
public class Solicitud {
    
    // Identity
    private String solicitudId;
    private String numeroSolicitud;
    
    // Estado y clasificación
    private String estado;
    private String tipoTramite;
    private String subTipoTramite;
    private String prioridad;
    private String tipoSolicitante;
    
    // Información del solicitante
    private Solicitante solicitante;
    
    // Requisitos y datos específicos
    private List<RequisitoCumplido> requisitosCumplidos;
    private DatosEspecificosTramite datosEspecificosTramite;
    private List<DocumentoAdjunto> documentosAdjuntos;
    
    // Pago
    private Pago pago;
    
    // Observaciones y notas
    private String observaciones;
    
    // Auditoría y seguimiento
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaVencimiento;
    private String usuarioRegistro;
    private String usuarioAsignado;
    private OficinaRegistro oficinaRegistro;
    
    // Estimación de tiempo
    private Long tiempoEstimadoResolucion;
    
    // Flag de diligencia
    private Boolean requiereDiligencia;

    public Solicitud() {
        this.requisitosCumplidos = new ArrayList<>();
        this.documentosAdjuntos = new ArrayList<>();
    }

    public Solicitud(String solicitudId, String numeroSolicitud, String estado, String tipoTramite,
                     String subTipoTramite, Solicitante solicitante, String tipoSolicitante, String prioridad,
                     List<RequisitoCumplido> requisitosCumplidos, DatosEspecificosTramite datosEspecificosTramite,
                     List<DocumentoAdjunto> documentosAdjuntos, Pago pago, String observaciones, 
                     LocalDateTime fechaRegistro, LocalDateTime fechaVencimiento,
                     String usuarioRegistro, String usuarioAsignado, OficinaRegistro oficinaRegistro,
                     Long tiempoEstimadoResolucion, Boolean requiereDiligencia) {
        this.solicitudId = solicitudId;
        this.numeroSolicitud = numeroSolicitud;
        this.estado = estado;
        this.tipoTramite = tipoTramite;
        this.subTipoTramite = subTipoTramite;
        this.solicitante = solicitante;
        this.tipoSolicitante = tipoSolicitante;
        this.prioridad = prioridad;
        this.requisitosCumplidos = requisitosCumplidos != null ? new ArrayList<>(requisitosCumplidos) : new ArrayList<>();
        this.datosEspecificosTramite = datosEspecificosTramite;
        this.documentosAdjuntos = documentosAdjuntos != null ? new ArrayList<>(documentosAdjuntos) : new ArrayList<>();
        this.pago = pago;
        this.observaciones = observaciones;
        this.fechaRegistro = fechaRegistro;
        this.fechaVencimiento = fechaVencimiento;
        this.usuarioRegistro = usuarioRegistro;
        this.usuarioAsignado = usuarioAsignado;
        this.oficinaRegistro = oficinaRegistro;
        this.tiempoEstimadoResolucion = tiempoEstimadoResolucion;
        this.requiereDiligencia = requiereDiligencia;
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getSubTipoTramite() {
        return subTipoTramite;
    }

    public void setSubTipoTramite(String subTipoTramite) {
        this.subTipoTramite = subTipoTramite;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public String getTipoSolicitante() {
        return tipoSolicitante;
    }

    public void setTipoSolicitante(String tipoSolicitante) {
        this.tipoSolicitante = tipoSolicitante;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public List<RequisitoCumplido> getRequisitosCumplidos() {
        return Collections.unmodifiableList(requisitosCumplidos);
    }

    public void setRequisitosCumplidos(List<RequisitoCumplido> requisitosCumplidos) {
        this.requisitosCumplidos = requisitosCumplidos != null ? new ArrayList<>(requisitosCumplidos) : new ArrayList<>();
    }
    
    public void agregarRequisito(RequisitoCumplido requisito) {
        if (requisito != null) {
            this.requisitosCumplidos.add(requisito);
        }
    }

    public List<DocumentoAdjunto> getDocumentosAdjuntos() {
        return Collections.unmodifiableList(documentosAdjuntos);
    }

    public void setDocumentosAdjuntos(List<DocumentoAdjunto> documentosAdjuntos) {
        this.documentosAdjuntos = documentosAdjuntos != null ? new ArrayList<>(documentosAdjuntos) : new ArrayList<>();
    }
    
    public void agregarDocumento(DocumentoAdjunto documento) {
        if (documento != null) {
            this.documentosAdjuntos.add(documento);
        }
    }

    public DatosEspecificosTramite getDatosEspecificosTramite() {
        return datosEspecificosTramite;
    }

    public void setDatosEspecificosTramite(DatosEspecificosTramite datosEspecificosTramite) {
        this.datosEspecificosTramite = datosEspecificosTramite;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
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

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public OficinaRegistro getOficinaRegistro() {
        return oficinaRegistro;
    }

    public void setOficinaRegistro(OficinaRegistro oficinaRegistro) {
        this.oficinaRegistro = oficinaRegistro;
    }

    public Long getTiempoEstimadoResolucion() {
        return tiempoEstimadoResolucion;
    }

    public void setTiempoEstimadoResolucion(Long tiempoEstimadoResolucion) {
        this.tiempoEstimadoResolucion = tiempoEstimadoResolucion;
    }

    public String getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(String usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }

    public Boolean getRequiereDiligencia() {
        return requiereDiligencia;
    }

    public void setRequiereDiligencia(Boolean requiereDiligencia) {
        this.requiereDiligencia = requiereDiligencia;
    }
    
    // Métodos de negocio
    
    public boolean estaVencida() {
        if (fechaVencimiento == null) {
            return false;
        }
        return LocalDateTime.now().isAfter(fechaVencimiento);
    }
    
    public boolean estaPendiente() {
        return "PENDIENTE".equalsIgnoreCase(estado) || "EN_PROCESO".equalsIgnoreCase(estado);
    }
    
    public void cambiarEstado(String nuevoEstado) {
        if (nuevoEstado != null && !nuevoEstado.trim().isEmpty()) {
            this.estado = nuevoEstado;
        }
    }
    
    public void asignarUsuario(String usuarioId) {
        this.usuarioAsignado = usuarioId;
    }
}
