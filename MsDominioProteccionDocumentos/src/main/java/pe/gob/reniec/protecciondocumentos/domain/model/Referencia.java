package pe.gob.reniec.protecciondocumentos.domain.model;

public class Referencia {
    private String sistema;
    private String transaccionId;
    private String codigoSeguimiento;

    public Referencia() {
    }

    public Referencia(String sistema, String transaccionId, String codigoSeguimiento) {
        this.sistema = sistema;
        this.transaccionId = transaccionId;
        this.codigoSeguimiento = codigoSeguimiento;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
    }

    public String getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    public void setCodigoSeguimiento(String codigoSeguimiento) {
        this.codigoSeguimiento = codigoSeguimiento;
    }
}
