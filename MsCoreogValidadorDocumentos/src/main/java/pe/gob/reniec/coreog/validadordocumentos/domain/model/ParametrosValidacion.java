package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.util.List;

/**
 * Objeto de valor que representa parámetros de validación de documentos
 */
public class ParametrosValidacion {
    private Double nivelPonderacionMinimo;
    private String modeloIA;
    private List<TipoObservacion> tiposObservacion;

    public ParametrosValidacion() {
    }

    public ParametrosValidacion(Double nivelPonderacionMinimo, String modeloIA, 
                                List<TipoObservacion> tiposObservacion) {
        this.nivelPonderacionMinimo = nivelPonderacionMinimo;
        this.modeloIA = modeloIA;
        this.tiposObservacion = tiposObservacion;
    }

    public Double getNivelPonderacionMinimo() {
        return nivelPonderacionMinimo;
    }

    public void setNivelPonderacionMinimo(Double nivelPonderacionMinimo) {
        this.nivelPonderacionMinimo = nivelPonderacionMinimo;
    }

    public String getModeloIA() {
        return modeloIA;
    }

    public void setModeloIA(String modeloIA) {
        this.modeloIA = modeloIA;
    }

    public List<TipoObservacion> getTiposObservacion() {
        return tiposObservacion;
    }

    public void setTiposObservacion(List<TipoObservacion> tiposObservacion) {
        this.tiposObservacion = tiposObservacion;
    }
}
