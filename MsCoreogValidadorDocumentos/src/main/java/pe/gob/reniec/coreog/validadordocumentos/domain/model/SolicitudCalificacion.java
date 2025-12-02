package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Aggregate Root que representa una solicitud de calificación de documentos
 */
public class SolicitudCalificacion {
    private String solicitudId;
    private String tramiteId;
    private String tipoTramite;
    private List<Documento> documentos;
    private ParametrosValidacion parametrosValidacion;
    private String usuarioSolicita;
    private String oficinaOrigen;
    private LocalDateTime fechaSolicitud;
    private String observaciones;

    public SolicitudCalificacion() {
    }

    public SolicitudCalificacion(String solicitudId, String tramiteId, String tipoTramite, 
                                 List<Documento> documentos, ParametrosValidacion parametrosValidacion, 
                                 String usuarioSolicita, String oficinaOrigen, 
                                 LocalDateTime fechaSolicitud, String observaciones) {
        this.solicitudId = solicitudId;
        this.tramiteId = tramiteId;
        this.tipoTramite = tipoTramite;
        this.documentos = documentos;
        this.parametrosValidacion = parametrosValidacion;
        this.usuarioSolicita = usuarioSolicita;
        this.oficinaOrigen = oficinaOrigen;
        this.fechaSolicitud = fechaSolicitud;
        this.observaciones = observaciones;
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public ParametrosValidacion getParametrosValidacion() {
        return parametrosValidacion;
    }

    public void setParametrosValidacion(ParametrosValidacion parametrosValidacion) {
        this.parametrosValidacion = parametrosValidacion;
    }

    public String getUsuarioSolicita() {
        return usuarioSolicita;
    }

    public void setUsuarioSolicita(String usuarioSolicita) {
        this.usuarioSolicita = usuarioSolicita;
    }

    public String getOficinaOrigen() {
        return oficinaOrigen;
    }

    public void setOficinaOrigen(String oficinaOrigen) {
        this.oficinaOrigen = oficinaOrigen;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
