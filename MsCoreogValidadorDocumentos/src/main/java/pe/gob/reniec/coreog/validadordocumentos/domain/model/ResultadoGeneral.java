package pe.gob.reniec.coreog.validadordocumentos.domain.model;

/**
 * Objeto de valor que representa el resultado general de una evaluación
 */
public class ResultadoGeneral {
    private String estado;
    private Double scorePromedio;
    private String nivelRiesgo;
    private Boolean alertaFraude;
    private Boolean requiereRevisionManual;
    private String observacionesGenerales;

    public ResultadoGeneral() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getScorePromedio() {
        return scorePromedio;
    }

    public void setScorePromedio(Double scorePromedio) {
        this.scorePromedio = scorePromedio;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public Boolean getAlertaFraude() {
        return alertaFraude;
    }

    public void setAlertaFraude(Boolean alertaFraude) {
        this.alertaFraude = alertaFraude;
    }

    public Boolean getRequiereRevisionManual() {
        return requiereRevisionManual;
    }

    public void setRequiereRevisionManual(Boolean requiereRevisionManual) {
        this.requiereRevisionManual = requiereRevisionManual;
    }

    public String getObservacionesGenerales() {
        return observacionesGenerales;
    }

    public void setObservacionesGenerales(String observacionesGenerales) {
        this.observacionesGenerales = observacionesGenerales;
    }
}
