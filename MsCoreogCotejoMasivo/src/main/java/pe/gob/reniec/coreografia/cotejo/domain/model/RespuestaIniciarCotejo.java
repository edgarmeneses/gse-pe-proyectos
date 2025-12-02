package pe.gob.reniec.coreografia.cotejo.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class RespuestaIniciarCotejo {
    private String solicitudId;
    private String numeroSolicitud;
    private String estado;
    private String tipoTramite;
    private EntidadSolicitante entidadSolicitante;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    private OficinaRegistro oficinaRegistro;
    private ResumenSolicitud resumenSolicitud;
    private List<SiguientePaso> siguientesPasos;
    private String urlSeguimiento;
    private List<EventoGenerado> eventosGenerados;

    public RespuestaIniciarCotejo() {
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

    public EntidadSolicitante getEntidadSolicitante() {
        return entidadSolicitante;
    }

    public void setEntidadSolicitante(EntidadSolicitante entidadSolicitante) {
        this.entidadSolicitante = entidadSolicitante;
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

    public OficinaRegistro getOficinaRegistro() {
        return oficinaRegistro;
    }

    public void setOficinaRegistro(OficinaRegistro oficinaRegistro) {
        this.oficinaRegistro = oficinaRegistro;
    }

    public ResumenSolicitud getResumenSolicitud() {
        return resumenSolicitud;
    }

    public void setResumenSolicitud(ResumenSolicitud resumenSolicitud) {
        this.resumenSolicitud = resumenSolicitud;
    }

    public List<SiguientePaso> getSiguientesPasos() {
        return siguientesPasos;
    }

    public void setSiguientesPasos(List<SiguientePaso> siguientesPasos) {
        this.siguientesPasos = siguientesPasos;
    }

    public String getUrlSeguimiento() {
        return urlSeguimiento;
    }

    public void setUrlSeguimiento(String urlSeguimiento) {
        this.urlSeguimiento = urlSeguimiento;
    }

    public List<EventoGenerado> getEventosGenerados() {
        return eventosGenerados;
    }

    public void setEventosGenerados(List<EventoGenerado> eventosGenerados) {
        this.eventosGenerados = eventosGenerados;
    }
}
