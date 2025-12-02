package pe.gob.reniec.gse.datosparentesco.domain.model;

import java.util.List;

public class CriteriosBusqueda {
    private RangoAnios rangoAniosPadres;
    private RangoAnios rangoAniosHijos;
    private List<String> variacionesNombre;

    public CriteriosBusqueda() {
    }

    public CriteriosBusqueda(RangoAnios rangoAniosPadres, RangoAnios rangoAniosHijos, List<String> variacionesNombre) {
        this.rangoAniosPadres = rangoAniosPadres;
        this.rangoAniosHijos = rangoAniosHijos;
        this.variacionesNombre = variacionesNombre;
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
}
