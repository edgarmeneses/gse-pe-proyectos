package pe.gob.reniec.pago.MsAdaptadorPagos.domain.model;

public class Monto {
    private final Double valor;
    private final String moneda;

    public Monto(Double valor, String moneda) {
        this.valor = valor;
        this.moneda = moneda;
    }

    public Double getValor() { return valor; }
    public String getMoneda() { return moneda; }
}
