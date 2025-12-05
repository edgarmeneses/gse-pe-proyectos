package pe.gob.reniec.adaptadorbanconacion.domain.model;

public class DetalleTransaccion {

    private Double montoPagado;
    private String moneda;
    private String fechaPago;
    private String horaPago;
    private String codigoAgencia;
    private String nombreAgencia;
    private String numeroCuenta;
    private String codigoAutorizacion;

    public DetalleTransaccion() {
    }

    public DetalleTransaccion(Double montoPagado, String moneda, String fechaPago, String horaPago,
                              String codigoAgencia, String nombreAgencia, String numeroCuenta,
                              String codigoAutorizacion) {
        this.montoPagado = montoPagado;
        this.moneda = moneda;
        this.fechaPago = fechaPago;
        this.horaPago = horaPago;
        this.codigoAgencia = codigoAgencia;
        this.nombreAgencia = nombreAgencia;
        this.numeroCuenta = numeroCuenta;
        this.codigoAutorizacion = codigoAutorizacion;
    }

    public Double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(Double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getHoraPago() {
        return horaPago;
    }

    public void setHoraPago(String horaPago) {
        this.horaPago = horaPago;
    }

    public String getCodigoAgencia() {
        return codigoAgencia;
    }

    public void setCodigoAgencia(String codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getCodigoAutorizacion() {
        return codigoAutorizacion;
    }

    public void setCodigoAutorizacion(String codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }
}
