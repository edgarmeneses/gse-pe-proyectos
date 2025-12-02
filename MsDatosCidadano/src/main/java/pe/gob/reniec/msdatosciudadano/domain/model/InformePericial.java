package pe.gob.reniec.msdatosciudadano.domain.model;

import java.time.LocalDateTime;

public class InformePericial {
    private String informeId;
    private String ciudadanoId;
    private String solicitudId;
    private LocalDateTime fechaGeneracion;
    private Boolean huellaCoincide;
    private Boolean rostroCoincide;
    private String urlPdf;

    public InformePericial() {
    }

    public String getInformeId() {
        return informeId;
    }

    public void setInformeId(String informeId) {
        this.informeId = informeId;
    }

    public String getCiudadanoId() {
        return ciudadanoId;
    }

    public void setCiudadanoId(String ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Boolean getHuellaCoincide() {
        return huellaCoincide;
    }

    public void setHuellaCoincide(Boolean huellaCoincide) {
        this.huellaCoincide = huellaCoincide;
    }

    public Boolean getRostroCoincide() {
        return rostroCoincide;
    }

    public void setRostroCoincide(Boolean rostroCoincide) {
        this.rostroCoincide = rostroCoincide;
    }

    public String getUrlPdf() {
        return urlPdf;
    }

    public void setUrlPdf(String urlPdf) {
        this.urlPdf = urlPdf;
    }
}
