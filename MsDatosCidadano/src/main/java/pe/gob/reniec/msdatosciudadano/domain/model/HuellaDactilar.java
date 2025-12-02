package pe.gob.reniec.msdatosciudadano.domain.model;

public class HuellaDactilar {
    private String nombreDedo;
    private String formato;
    private String valorBase64;

    public HuellaDactilar() {
    }

    public HuellaDactilar(String nombreDedo, String formato, String valorBase64) {
        this.nombreDedo = nombreDedo;
        this.formato = formato;
        this.valorBase64 = valorBase64;
    }

    public String getNombreDedo() {
        return nombreDedo;
    }

    public void setNombreDedo(String nombreDedo) {
        this.nombreDedo = nombreDedo;
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
}
