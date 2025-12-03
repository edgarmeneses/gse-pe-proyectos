package pe.gob.pj.solicitudes.data.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Aggregate Root: Diligencia
 * Representa una diligencia o gestión externa relacionada a una solicitud
 */
public class Diligencia {
    
    // Identity
    private String diligenciaId;
    private String numeroDiligencia;
    
    // Relación con Solicitud
    private String solicitudId;
    private String numeroSolicitud;
    
    // Estado y clasificación
    private String estado;
    private String tipoDiligencia;
    private String prioridad;
    
    // Entidad destino
    private String entidadDestino;
    private String tipoEntidad;
    private DatosContactoEntidad datosContactoEntidad;
    
    // Detalles de la diligencia
    private String motivoDiligencia;
    private String fundamentoLegal;
    private String informacionRequerida;
    private String observaciones;
    private List<DocumentoRequerido> documentosRequeridos;
    
    // Documentos generados
    private List<DocumentoGenerado> documentosGenerados;
    
    // Plazos
    private Long plazoRespuesta;
    private String unidadPlazo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaVencimiento;
    
    // Configuración de respuesta
    private Boolean requiereRespuestaOficial;
    private Boolean permitoRespuestaDigital;
    
    // Oficina y usuario responsable
    private OficinaResponsable oficinaResponsable;
    private String usuarioSolicitante;
    
    // Estado del oficio
    private String estadoOficio;

    public Diligencia() {
        this.documentosRequeridos = new ArrayList<>();
        this.documentosGenerados = new ArrayList<>();
    }

    public Diligencia(String diligenciaId, String numeroDiligencia, String solicitudId, String numeroSolicitud,
                      String estado, String tipoDiligencia, String prioridad, String entidadDestino, String tipoEntidad,
                      DatosContactoEntidad datosContactoEntidad, String motivoDiligencia, String fundamentoLegal,
                      String informacionRequerida, String observaciones, List<DocumentoRequerido> documentosRequeridos,
                      List<DocumentoGenerado> documentosGenerados, Long plazoRespuesta, String unidadPlazo, 
                      LocalDateTime fechaCreacion, LocalDateTime fechaVencimiento, Boolean requiereRespuestaOficial,
                      Boolean permitoRespuestaDigital, OficinaResponsable oficinaResponsable, 
                      String usuarioSolicitante, String estadoOficio) {
        this.diligenciaId = diligenciaId;
        this.numeroDiligencia = numeroDiligencia;
        this.solicitudId = solicitudId;
        this.numeroSolicitud = numeroSolicitud;
        this.estado = estado;
        this.tipoDiligencia = tipoDiligencia;
        this.prioridad = prioridad;
        this.entidadDestino = entidadDestino;
        this.tipoEntidad = tipoEntidad;
        this.datosContactoEntidad = datosContactoEntidad;
        this.motivoDiligencia = motivoDiligencia;
        this.fundamentoLegal = fundamentoLegal;
        this.informacionRequerida = informacionRequerida;
        this.observaciones = observaciones;
        this.documentosRequeridos = documentosRequeridos != null ? new ArrayList<>(documentosRequeridos) : new ArrayList<>();
        this.documentosGenerados = documentosGenerados != null ? new ArrayList<>(documentosGenerados) : new ArrayList<>();
        this.plazoRespuesta = plazoRespuesta;
        this.unidadPlazo = unidadPlazo;
        this.fechaCreacion = fechaCreacion;
        this.fechaVencimiento = fechaVencimiento;
        this.requiereRespuestaOficial = requiereRespuestaOficial;
        this.permitoRespuestaDigital = permitoRespuestaDigital;
        this.oficinaResponsable = oficinaResponsable;
        this.usuarioSolicitante = usuarioSolicitante;
        this.estadoOficio = estadoOficio;
    }

    public String getDiligenciaId() {
        return diligenciaId;
    }

    public void setDiligenciaId(String diligenciaId) {
        this.diligenciaId = diligenciaId;
    }

    public String getNumeroDiligencia() {
        return numeroDiligencia;
    }

    public void setNumeroDiligencia(String numeroDiligencia) {
        this.numeroDiligencia = numeroDiligencia;
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

    public String getTipoDiligencia() {
        return tipoDiligencia;
    }

    public void setTipoDiligencia(String tipoDiligencia) {
        this.tipoDiligencia = tipoDiligencia;
    }

    public String getEntidadDestino() {
        return entidadDestino;
    }

    public void setEntidadDestino(String entidadDestino) {
        this.entidadDestino = entidadDestino;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public DatosContactoEntidad getDatosContactoEntidad() {
        return datosContactoEntidad;
    }

    public void setDatosContactoEntidad(DatosContactoEntidad datosContactoEntidad) {
        this.datosContactoEntidad = datosContactoEntidad;
    }

    public String getMotivoDiligencia() {
        return motivoDiligencia;
    }

    public void setMotivoDiligencia(String motivoDiligencia) {
        this.motivoDiligencia = motivoDiligencia;
    }

    public String getFundamentoLegal() {
        return fundamentoLegal;
    }

    public void setFundamentoLegal(String fundamentoLegal) {
        this.fundamentoLegal = fundamentoLegal;
    }

    public String getInformacionRequerida() {
        return informacionRequerida;
    }

    public void setInformacionRequerida(String informacionRequerida) {
        this.informacionRequerida = informacionRequerida;
    }

    public List<DocumentoRequerido> getDocumentosRequeridos() {
        return Collections.unmodifiableList(documentosRequeridos);
    }

    public void setDocumentosRequeridos(List<DocumentoRequerido> documentosRequeridos) {
        this.documentosRequeridos = documentosRequeridos != null ? new ArrayList<>(documentosRequeridos) : new ArrayList<>();
    }
    
    public void agregarDocumentoRequerido(DocumentoRequerido documento) {
        if (documento != null) {
            this.documentosRequeridos.add(documento);
        }
    }

    public List<DocumentoGenerado> getDocumentosGenerados() {
        return Collections.unmodifiableList(documentosGenerados);
    }

    public void setDocumentosGenerados(List<DocumentoGenerado> documentosGenerados) {
        this.documentosGenerados = documentosGenerados != null ? new ArrayList<>(documentosGenerados) : new ArrayList<>();
    }
    
    public void agregarDocumentoGenerado(DocumentoGenerado documento) {
        if (documento != null) {
            this.documentosGenerados.add(documento);
        }
    }

    public Long getPlazoRespuesta() {
        return plazoRespuesta;
    }

    public void setPlazoRespuesta(Long plazoRespuesta) {
        this.plazoRespuesta = plazoRespuesta;
    }

    public String getUnidadPlazo() {
        return unidadPlazo;
    }

    public void setUnidadPlazo(String unidadPlazo) {
        this.unidadPlazo = unidadPlazo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Boolean getRequiereRespuestaOficial() {
        return requiereRespuestaOficial;
    }

    public void setRequiereRespuestaOficial(Boolean requiereRespuestaOficial) {
        this.requiereRespuestaOficial = requiereRespuestaOficial;
    }

    public Boolean getPermitoRespuestaDigital() {
        return permitoRespuestaDigital;
    }

    public void setPermitoRespuestaDigital(Boolean permitoRespuestaDigital) {
        this.permitoRespuestaDigital = permitoRespuestaDigital;
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

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public OficinaResponsable getOficinaResponsable() {
        return oficinaResponsable;
    }

    public void setOficinaResponsable(OficinaResponsable oficinaResponsable) {
        this.oficinaResponsable = oficinaResponsable;
    }

    public String getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(String usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    public String getEstadoOficio() {
        return estadoOficio;
    }

    public void setEstadoOficio(String estadoOficio) {
        this.estadoOficio = estadoOficio;
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
    
    public void marcarOficioEnviado() {
        this.estadoOficio = "ENVIADO";
    }
    
    public void marcarOficioRespondido() {
        this.estadoOficio = "RESPONDIDO";
    }
}
