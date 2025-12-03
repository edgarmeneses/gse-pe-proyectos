package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

public class SolicitudEntity {
    
    private String solicitudId;
    private String numeroSolicitud;
    private String estado;
    private String tipoTramite;
    private String subTipoTramite;
    private String dniSolicitante;
    private String nombresSolicitante;
    private String apellidoPaternoSolicitante;
    private String apellidoMaternoSolicitante;
    private String emailSolicitante;
    private String telefonoSolicitante;
    private String tipoSolicitante;
    private String prioridad;
    private String observaciones;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaVencimiento;
    private String usuarioRegistro;
    private String codigoOficinaRegistro;
    private String nombreOficinaRegistro;
    private Long tiempoEstimadoResolucion;
    private String urlSeguimiento;
    private String codigoQR;
    private Long diasTranscurridos;
    private Long diasRestantes;
    private String usuarioAsignado;
    private Boolean requiereDiligencia;

    public SolicitudEntity() {
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

    public String getDniSolicitante() {
        return dniSolicitante;
    }

    public void setDniSolicitante(String dniSolicitante) {
        this.dniSolicitante = dniSolicitante;
    }

    public String getNombresSolicitante() {
        return nombresSolicitante;
    }

    public void setNombresSolicitante(String nombresSolicitante) {
        this.nombresSolicitante = nombresSolicitante;
    }

    public String getApellidoPaternoSolicitante() {
        return apellidoPaternoSolicitante;
    }

    public void setApellidoPaternoSolicitante(String apellidoPaternoSolicitante) {
        this.apellidoPaternoSolicitante = apellidoPaternoSolicitante;
    }

    public String getApellidoMaternoSolicitante() {
        return apellidoMaternoSolicitante;
    }

    public void setApellidoMaternoSolicitante(String apellidoMaternoSolicitante) {
        this.apellidoMaternoSolicitante = apellidoMaternoSolicitante;
    }

    public String getEmailSolicitante() {
        return emailSolicitante;
    }

    public void setEmailSolicitante(String emailSolicitante) {
        this.emailSolicitante = emailSolicitante;
    }

    public String getTelefonoSolicitante() {
        return telefonoSolicitante;
    }

    public void setTelefonoSolicitante(String telefonoSolicitante) {
        this.telefonoSolicitante = telefonoSolicitante;
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

    public String getCodigoOficinaRegistro() {
        return codigoOficinaRegistro;
    }

    public void setCodigoOficinaRegistro(String codigoOficinaRegistro) {
        this.codigoOficinaRegistro = codigoOficinaRegistro;
    }

    public String getNombreOficinaRegistro() {
        return nombreOficinaRegistro;
    }

    public void setNombreOficinaRegistro(String nombreOficinaRegistro) {
        this.nombreOficinaRegistro = nombreOficinaRegistro;
    }

    public Long getTiempoEstimadoResolucion() {
        return tiempoEstimadoResolucion;
    }

    public void setTiempoEstimadoResolucion(Long tiempoEstimadoResolucion) {
        this.tiempoEstimadoResolucion = tiempoEstimadoResolucion;
    }

    public String getUrlSeguimiento() {
        return urlSeguimiento;
    }

    public void setUrlSeguimiento(String urlSeguimiento) {
        this.urlSeguimiento = urlSeguimiento;
    }

    public String getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }

    public Long getDiasTranscurridos() {
        return diasTranscurridos;
    }

    public void setDiasTranscurridos(Long diasTranscurridos) {
        this.diasTranscurridos = diasTranscurridos;
    }

    public Long getDiasRestantes() {
        return diasRestantes;
    }

    public void setDiasRestantes(Long diasRestantes) {
        this.diasRestantes = diasRestantes;
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
}
