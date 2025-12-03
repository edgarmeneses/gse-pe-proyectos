package pe.gob.reniec.msdatosciudadano.domain.model;

public class Fotografia {
    private String formato;
    private String valorBase64;
    private String resolucion;
    private String modoCaptura;

    public Fotografia() {
    }

    public Fotografia(String formato, String valorBase64, String resolucion, String modoCaptura) {
        this.formato = formato;
        this.valorBase64 = valorBase64;
        this.resolucion = resolucion;
        this.modoCaptura = modoCaptura;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getValorBase64() {
        return valorBase64;
    }

    public void setValorBase64(String valorBase64) {
        this.valorBase64 = valorBase64;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getModoCaptura() {
        return modoCaptura;
    }

    public void setModoCaptura(String modoCaptura) {
        this.modoCaptura = modoCaptura;
    }
}
