package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

public class DiligenciaEntity {
    
    private String diligenciaId;
    private String numeroDiligencia;
    private String solicitudId;
    private String numeroSolicitud;
    private String estado;
    private String tipoDiligencia;
    private String entidadDestino;
    private String tipoEntidad;
    private String motivoDiligencia;
    private String fundamentoLegal;
    private String informacionRequerida;
    private Long plazoRespuesta;
    private String unidadPlazo;
    private String prioridad;
    private Boolean requiereRespuestaOficial;
    private Boolean permitoRespuestaDigital;
    private String observaciones;
    private String oficinaResponsableSeguimiento;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaVencimiento;
    private Long diasTranscurridos;
    private Long diasRestantes;
    private String usuarioSolicitante;
    private String estadoOficio;

    public DiligenciaEntity() {
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

    public String getOficinaResponsableSeguimiento() {
        return oficinaResponsableSeguimiento;
    }

    public void setOficinaResponsableSeguimiento(String oficinaResponsableSeguimiento) {
        this.oficinaResponsableSeguimiento = oficinaResponsableSeguimiento;
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
}
