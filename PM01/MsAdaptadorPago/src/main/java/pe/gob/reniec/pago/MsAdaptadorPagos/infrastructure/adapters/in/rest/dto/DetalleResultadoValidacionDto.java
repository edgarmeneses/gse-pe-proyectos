package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto;

public class DetalleResultadoValidacionDto {
    private String validacionId;
    private Boolean esValido;
    private String estadoTransaccion;

    public DetalleResultadoValidacionDto() {}

    public String getValidacionId() { return validacionId; }
    public void setValidacionId(String validacionId) { this.validacionId = validacionId; }

    public Boolean getEsValido() { return esValido; }
    public void setEsValido(Boolean esValido) { this.esValido = esValido; }

    public String getEstadoTransaccion() { return estadoTransaccion; }
    public void setEstadoTransaccion(String estadoTransaccion) { this.estadoTransaccion = estadoTransaccion; }
}
