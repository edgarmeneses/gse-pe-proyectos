package pe.gob.reniec.protecciondocumentos.domain.model;

import java.time.LocalDateTime;

public class ProteccionDocumento {
    private String proteccionId;
    private String solicitudId;
    private ArchivoProtegido archivoProtegido;
    private InformacionSeguridad seguridad;
    private EstadisticasCompresion compresion;
    private String estado;
    private LocalDateTime fechaProcesamiento;
    private LinksHATEOAS links;

    public ProteccionDocumento() {
    }

    public ProteccionDocumento(String proteccionId, String solicitudId, ArchivoProtegido archivoProtegido, 
                              InformacionSeguridad seguridad, EstadisticasCompresion compresion, 
                              String estado, LocalDateTime fechaProcesamiento, LinksHATEOAS links) {
        this.proteccionId = proteccionId;
        this.solicitudId = solicitudId;
        this.archivoProtegido = archivoProtegido;
        this.seguridad = seguridad;
        this.compresion = compresion;
        this.estado = estado;
        this.fechaProcesamiento = fechaProcesamiento;
        this.links = links;
    }

    public String getProteccionId() {
        return proteccionId;
    }

    public void setProteccionId(String proteccionId) {
        this.proteccionId = proteccionId;
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public ArchivoProtegido getArchivoProtegido() {
        return archivoProtegido;
    }

    public void setArchivoProtegido(ArchivoProtegido archivoProtegido) {
        this.archivoProtegido = archivoProtegido;
    }

    public InformacionSeguridad getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(InformacionSeguridad seguridad) {
        this.seguridad = seguridad;
    }

    public EstadisticasCompresion getCompresion() {
        return compresion;
    }

    public void setCompresion(EstadisticasCompresion compresion) {
        this.compresion = compresion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaProcesamiento() {
        return fechaProcesamiento;
    }

    public void setFechaProcesamiento(LocalDateTime fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }

    public LinksHATEOAS getLinks() {
        return links;
    }

    public void setLinks(LinksHATEOAS links) {
        this.links = links;
    }
}
