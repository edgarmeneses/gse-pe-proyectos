package pe.gob.reniec.protecciondocumentos.domain.model;

public class Fuente {
    private String tipo;
    private String origen;
    private Referencia referencia;

    public Fuente() {
    }

    public Fuente(String tipo, String origen, Referencia referencia) {
        this.tipo = tipo;
        this.origen = origen;
        this.referencia = referencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Referencia getReferencia() {
        return referencia;
    }

    public void setReferencia(Referencia referencia) {
        this.referencia = referencia;
    }
}
