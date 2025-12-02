package pe.gob.reniec.dominio.parentesco.domain.model;

import java.util.List;

public class CriteriosBusqueda {
    private RangoAnios rangoAniosPadres;
    private RangoAnios rangoAniosHijos;
    private List<String> variacionesNombre;
    private Boolean incluirFallecidos;
    private Boolean incluirActasAnuladas;

    public CriteriosBusqueda() {
    }

    public CriteriosBusqueda(RangoAnios rangoAniosPadres, RangoAnios rangoAniosHijos,
                            List<String> variacionesNombre, Boolean incluirFallecidos,
                            Boolean incluirActasAnuladas) {
        this.rangoAniosPadres = rangoAniosPadres;
        this.rangoAniosHijos = rangoAniosHijos;
        this.variacionesNombre = variacionesNombre;
        this.incluirFallecidos = incluirFallecidos;
        this.incluirActasAnuladas = incluirActasAnuladas;
    }

    public RangoAnios getRangoAniosPadres() {
        return rangoAniosPadres;
    }

    public void setRangoAniosPadres(RangoAnios rangoAniosPadres) {
        this.rangoAniosPadres = rangoAniosPadres;
    }

    public RangoAnios getRangoAniosHijos() {
        return rangoAniosHijos;
    }

    public void setRangoAniosHijos(RangoAnios rangoAniosHijos) {
        this.rangoAniosHijos = rangoAniosHijos;
    }

    public List<String> getVariacionesNombre() {
        return variacionesNombre;
    }

    public void setVariacionesNombre(List<String> variacionesNombre) {
        this.variacionesNombre = variacionesNombre;
    }

    public Boolean getIncluirFallecidos() {
        return incluirFallecidos;
    }

    public void setIncluirFallecidos(Boolean incluirFallecidos) {
        this.incluirFallecidos = incluirFallecidos;
    }

    public Boolean getIncluirActasAnuladas() {
        return incluirActasAnuladas;
    }

    public void setIncluirActasAnuladas(Boolean incluirActasAnuladas) {
        this.incluirActasAnuladas = incluirActasAnuladas;
    }
}
