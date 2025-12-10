package pe.reniec.firma.domain.model;

public class Auditoria {
    private String idTransaccionProveedor;
    private String loteIniciado;
    private String loteCompletado;
    private Integer tiempoProcesamientoMs;
    private String proveedorUtilizado;

    public Auditoria() {}

    public String getIdTransaccionProveedor() {
        return idTransaccionProveedor;
    }

    public void setIdTransaccionProveedor(String idTransaccionProveedor) {
        this.idTransaccionProveedor = idTransaccionProveedor;
    }

    public String getLoteIniciado() {
        return loteIniciado;
    }

    public void setLoteIniciado(String loteIniciado) {
        this.loteIniciado = loteIniciado;
    }

    public String getLoteCompletado() {
        return loteCompletado;
    }

    public void setLoteCompletado(String loteCompletado) {
        this.loteCompletado = loteCompletado;
    }

    public Integer getTiempoProcesamientoMs() {
        return tiempoProcesamientoMs;
    }

    public void setTiempoProcesamientoMs(Integer tiempoProcesamientoMs) {
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
    }

    public String getProveedorUtilizado() {
        return proveedorUtilizado;
    }

    public void setProveedorUtilizado(String proveedorUtilizado) {
        this.proveedorUtilizado = proveedorUtilizado;
    }
}
