package pe.gob.reniec.msdatosciudadano.domain.model;

import java.util.List;

public class ConfiguracionCotejo {
    private List<String> camposACotejar;
    private Double toleranciaCoincidencia;
    private Boolean generarReporteDetallado;

    public ConfiguracionCotejo() {
    }

    public ConfiguracionCotejo(List<String> camposACotejar, Double toleranciaCoincidencia, Boolean generarReporteDetallado) {
        this.camposACotejar = camposACotejar;
        this.toleranciaCoincidencia = toleranciaCoincidencia;
        this.generarReporteDetallado = generarReporteDetallado;
    }

    public List<String> getCamposACotejar() {
        return camposACotejar;
    }

    public void setCamposACotejar(List<String> camposACotejar) {
        this.camposACotejar = camposACotejar;
    }

    public Double getToleranciaCoincidencia() {
        return toleranciaCoincidencia;
    }

    public void setToleranciaCoincidencia(Double toleranciaCoincidencia) {
        this.toleranciaCoincidencia = toleranciaCoincidencia;
    }

    public Boolean getGenerarReporteDetallado() {
        return generarReporteDetallado;
    }

    public void setGenerarReporteDetallado(Boolean generarReporteDetallado) {
        this.generarReporteDetallado = generarReporteDetallado;
    }
}
