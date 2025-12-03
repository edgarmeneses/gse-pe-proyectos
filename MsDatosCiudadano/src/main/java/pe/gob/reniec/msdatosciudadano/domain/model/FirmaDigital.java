package pe.gob.reniec.msdatosciudadano.domain.model;

public class FirmaDigital {
    private String formato;
    private String valorBase64;
    private String dispositivoCaptura;

    public FirmaDigital() {
    }

    public FirmaDigital(String formato, String valorBase64, String dispositivoCaptura) {
        this.formato = formato;
        this.valorBase64 = valorBase64;
        this.dispositivoCaptura = dispositivoCaptura;
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

    public String getDispositivoCaptura() {
        return dispositivoCaptura;
    }

    public void setDispositivoCaptura(String dispositivoCaptura) {
        this.dispositivoCaptura = dispositivoCaptura;
    }
}
