package pe.reniec.firma.domain.model;

public class Certificado {
    private String numeroSerie;
    private String emisor;
    private String vigenciaDesde;
    private String vigenciaHasta;
    private String algoritmo;
    private Integer longitudClave;

    public Certificado() {}

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getVigenciaDesde() {
        return vigenciaDesde;
    }

    public void setVigenciaDesde(String vigenciaDesde) {
        this.vigenciaDesde = vigenciaDesde;
    }

    public String getVigenciaHasta() {
        return vigenciaHasta;
    }

    public void setVigenciaHasta(String vigenciaHasta) {
        this.vigenciaHasta = vigenciaHasta;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public Integer getLongitudClave() {
        return longitudClave;
    }

    public void setLongitudClave(Integer longitudClave) {
        this.longitudClave = longitudClave;
    }
}
