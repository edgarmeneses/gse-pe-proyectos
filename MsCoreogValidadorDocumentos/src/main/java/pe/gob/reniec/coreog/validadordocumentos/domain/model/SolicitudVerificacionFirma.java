package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.time.LocalDateTime;

/**
 * Aggregate Root que representa una solicitud de verificación de firma
 */
public class SolicitudVerificacionFirma {
    private String solicitudId;
    private String tramiteId;
    private String tipoTramite;
    private Documento documento;
    private Registrador registrador;
    private FirmaDigital firmaDigital;
    private ParametrosValidacionFirma parametrosValidacionFirma;
    private String usuarioSolicita;
    private String oficinaOrigen;
    private LocalDateTime fechaSolicitud;
    private String observaciones;

    public SolicitudVerificacionFirma() {
    }

    public SolicitudVerificacionFirma(String solicitudId, String tramiteId, String tipoTramite, 
                                      Documento documento, Registrador registrador, 
                                      FirmaDigital firmaDigital, 
                                      ParametrosValidacionFirma parametrosValidacionFirma, 
                                      String usuarioSolicita, String oficinaOrigen, 
                                      LocalDateTime fechaSolicitud, String observaciones) {
        this.solicitudId = solicitudId;
        this.tramiteId = tramiteId;
        this.tipoTramite = tipoTramite;
        this.documento = documento;
        this.registrador = registrador;
        this.firmaDigital = firmaDigital;
        this.parametrosValidacionFirma = parametrosValidacionFirma;
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

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Registrador getRegistrador() {
        return registrador;
    }

    public void setRegistrador(Registrador registrador) {
        this.registrador = registrador;
    }

    public FirmaDigital getFirmaDigital() {
        return firmaDigital;
    }

    public void setFirmaDigital(FirmaDigital firmaDigital) {
        this.firmaDigital = firmaDigital;
    }

    public ParametrosValidacionFirma getParametrosValidacionFirma() {
        return parametrosValidacionFirma;
    }

    public void setParametrosValidacionFirma(ParametrosValidacionFirma parametrosValidacionFirma) {
        this.parametrosValidacionFirma = parametrosValidacionFirma;
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
