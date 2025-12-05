package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO que representa un documento evaluado en la capa REST.
 */
public class DocumentoEvaluadoDto {

    private String documentoId;
    private String tipoDocumental;
    private String nombreArchivo;
    private String estadoEvaluacion;
    private Double scoreConfiabilidad;
    private String nivelRiesgo;
    private Boolean alertaFraude;
    private List<ObservacionDto> observaciones;
    private MetricasDto metricas;
    private Integer tiempoProcesamientoMs;

    public DocumentoEvaluadoDto() {
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public String getTipoDocumental() {
        return tipoDocumental;
    }

    public void setTipoDocumental(String tipoDocumental) {
        this.tipoDocumental = tipoDocumental;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getEstadoEvaluacion() {
        return estadoEvaluacion;
    }

    public void setEstadoEvaluacion(String estadoEvaluacion) {
        this.estadoEvaluacion = estadoEvaluacion;
    }

    public Double getScoreConfiabilidad() {
        return scoreConfiabilidad;
    }

    public void setScoreConfiabilidad(Double scoreConfiabilidad) {
        this.scoreConfiabilidad = scoreConfiabilidad;
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

    public List<ObservacionDto> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<ObservacionDto> observaciones) {
        this.observaciones = observaciones;
    }

    public MetricasDto getMetricas() {
        return metricas;
    }

    public void setMetricas(MetricasDto metricas) {
        this.metricas = metricas;
    }

    public Integer getTiempoProcesamientoMs() {
        return tiempoProcesamientoMs;
    }

    public void setTiempoProcesamientoMs(Integer tiempoProcesamientoMs) {
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
    }
}
