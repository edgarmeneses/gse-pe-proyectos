package pe.gob.reniec.adaptadorbanconacion.domain.model;

import java.util.List;

public class Validacion {

    private String validacionId;
    private String codigoOperacion;
    private String numeroSolicitud;
    private Boolean esValido;
    private String estadoTransaccion;
    private DetalleTransaccion detalleTransaccion;
    private Coincidencias coincidencias;
    private Auditoria auditoria;
    private List<String> mensajes;

    public Validacion() {
    }

    public Validacion(String validacionId, String codigoOperacion, String numeroSolicitud,
                     Boolean esValido, String estadoTransaccion, DetalleTransaccion detalleTransaccion,
                     Coincidencias coincidencias, Auditoria auditoria, List<String> mensajes) {
        this.validacionId = validacionId;
        this.codigoOperacion = codigoOperacion;
        this.numeroSolicitud = numeroSolicitud;
        this.esValido = esValido;
        this.estadoTransaccion = estadoTransaccion;
        this.detalleTransaccion = detalleTransaccion;
        this.coincidencias = coincidencias;
        this.auditoria = auditoria;
        this.mensajes = mensajes;
    }

    public String getValidacionId() {
        return validacionId;
    }

    public void setValidacionId(String validacionId) {
        this.validacionId = validacionId;
    }

    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public Boolean getEsValido() {
        return esValido;
    }

    public void setEsValido(Boolean esValido) {
        this.esValido = esValido;
    }

    public String getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(String estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public DetalleTransaccion getDetalleTransaccion() {
        return detalleTransaccion;
    }

    public void setDetalleTransaccion(DetalleTransaccion detalleTransaccion) {
        this.detalleTransaccion = detalleTransaccion;
    }

    public Coincidencias getCoincidencias() {
        return coincidencias;
    }

    public void setCoincidencias(Coincidencias coincidencias) {
        this.coincidencias = coincidencias;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }
}
