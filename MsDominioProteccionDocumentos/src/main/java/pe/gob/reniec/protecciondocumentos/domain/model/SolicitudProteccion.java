package pe.gob.reniec.protecciondocumentos.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class SolicitudProteccion {
    private String solicitudId;
    private TipoOperacion tipoOperacion;
    private LocalDateTime fechaSolicitud;
    private Fuente fuente;
    private List<Documento> documentos;
    private ConfiguracionProteccion configuracion;
    private List<Destinatario> destinatarios;

    public SolicitudProteccion() {
    }

    public SolicitudProteccion(String solicitudId, TipoOperacion tipoOperacion, LocalDateTime fechaSolicitud,
                               Fuente fuente, List<Documento> documentos,
                               ConfiguracionProteccion configuracion, List<Destinatario> destinatarios) {
        this.solicitudId = solicitudId;
        this.tipoOperacion = tipoOperacion;
        this.fechaSolicitud = fechaSolicitud;
        this.fuente = fuente;
        this.documentos = documentos;
        this.configuracion = configuracion;
        this.destinatarios = destinatarios;
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Fuente getFuente() {
        return fuente;
    }

    public void setFuente(Fuente fuente) {
        this.fuente = fuente;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public ConfiguracionProteccion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionProteccion configuracion) {
        this.configuracion = configuracion;
    }

    public List<Destinatario> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<Destinatario> destinatarios) {
        this.destinatarios = destinatarios;
    }
}
