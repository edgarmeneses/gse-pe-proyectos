package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad que representa el resultado de una verificación de firma
 */
public class VerificacionFirma {
    private String verificacionId;
    private String solicitudId;
    private String tramiteId;
    private String documentoId;
    private LocalDateTime fechaVerificacion;
    private ResultadoVerificacion resultadoVerificacion;
    private DatosRegistrador datosRegistrador;
    private DatosFirmaDigital datosFirmaDigital;
    private List<Alerta> alertas;

    public VerificacionFirma() {
    }

    public String getVerificacionId() {
        return verificacionId;
    }

    public void setVerificacionId(String verificacionId) {
        this.verificacionId = verificacionId;
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

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public LocalDateTime getFechaVerificacion() {
        return fechaVerificacion;
    }

    public void setFechaVerificacion(LocalDateTime fechaVerificacion) {
        this.fechaVerificacion = fechaVerificacion;
    }

    public ResultadoVerificacion getResultadoVerificacion() {
        return resultadoVerificacion;
    }

    public void setResultadoVerificacion(ResultadoVerificacion resultadoVerificacion) {
        this.resultadoVerificacion = resultadoVerificacion;
    }

    public DatosRegistrador getDatosRegistrador() {
        return datosRegistrador;
    }

    public void setDatosRegistrador(DatosRegistrador datosRegistrador) {
        this.datosRegistrador = datosRegistrador;
    }

    public DatosFirmaDigital getDatosFirmaDigital() {
        return datosFirmaDigital;
    }

    public void setDatosFirmaDigital(DatosFirmaDigital datosFirmaDigital) {
        this.datosFirmaDigital = datosFirmaDigital;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }
}
