package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO que representa el contador de registros creados en la persistencia.
 */
public class RegistrosCreadosDto {

    private Integer evaluacionGeneral;
    private Integer documentosEvaluados;
    private Integer observaciones;
    private Integer metricas;
    private Integer accionesRecomendadas;

    public RegistrosCreadosDto() {
    }

    public Integer getEvaluacionGeneral() {
        return evaluacionGeneral;
    }

    public void setEvaluacionGeneral(Integer evaluacionGeneral) {
        this.evaluacionGeneral = evaluacionGeneral;
    }

    public Integer getDocumentosEvaluados() {
        return documentosEvaluados;
    }

    public void setDocumentosEvaluados(Integer documentosEvaluados) {
        this.documentosEvaluados = documentosEvaluados;
    }

    public Integer getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(Integer observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getMetricas() {
        return metricas;
    }

    public void setMetricas(Integer metricas) {
        this.metricas = metricas;
    }

    public Integer getAccionesRecomendadas() {
        return accionesRecomendadas;
    }

    public void setAccionesRecomendadas(Integer accionesRecomendadas) {
        this.accionesRecomendadas = accionesRecomendadas;
    }
}
