package pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ValidacionPagoResponseDto {

    private String validacionId;
    private String codigoOperacion;
    private String numeroSolicitud;
    private Boolean esValido;
    private String estadoTransaccion;
    private DetalleTransaccionDto detalleTransaccion;
    private CoincidenciasDto coincidencias;
    private AuditoriaDto auditoria;
    private List<String> mensajes;

    public ValidacionPagoResponseDto() {
    }

    public ValidacionPagoResponseDto(String validacionId, String codigoOperacion, String numeroSolicitud,
                                    Boolean esValido, String estadoTransaccion,
                                    DetalleTransaccionDto detalleTransaccion, CoincidenciasDto coincidencias,
                                    AuditoriaDto auditoria, List<String> mensajes) {
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

    public DetalleTransaccionDto getDetalleTransaccion() {
        return detalleTransaccion;
    }

    public void setDetalleTransaccion(DetalleTransaccionDto detalleTransaccion) {
        this.detalleTransaccion = detalleTransaccion;
    }

    public CoincidenciasDto getCoincidencias() {
        return coincidencias;
    }

    public void setCoincidencias(CoincidenciasDto coincidencias) {
        this.coincidencias = coincidencias;
    }

    public AuditoriaDto getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaDto auditoria) {
        this.auditoria = auditoria;
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }
}
