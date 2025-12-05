package pe.gob.reniec.validadordocumentos.domain.model;

import java.util.List;

/**
 * Entidad que representa un documento individual que ha sido evaluado.
 */
public class DocumentoEvaluado {

    private String documentoId;
    private String tipoDocumental;
    private String nombreArchivo;
    private String estadoEvaluacion;
    private Double scoreConfiabilidad;
    private String nivelRiesgo;
    private Boolean alertaFraude;
    private List<Observacion> observaciones;
    private Metricas metricas;
    private Integer tiempoProcesamientoMs;

    public DocumentoEvaluado() {
    }

    public DocumentoEvaluado(String documentoId, String tipoDocumental, String nombreArchivo,
                            String estadoEvaluacion, Double scoreConfiabilidad, String nivelRiesgo,
                            Boolean alertaFraude, List<Observacion> observaciones, Metricas metricas,
                            Integer tiempoProcesamientoMs) {
        this.documentoId = documentoId;
        this.tipoDocumental = tipoDocumental;
        this.nombreArchivo = nombreArchivo;
        this.estadoEvaluacion = estadoEvaluacion;
        this.scoreConfiabilidad = scoreConfiabilidad;
        this.nivelRiesgo = nivelRiesgo;
        this.alertaFraude = alertaFraude;
        this.observaciones = observaciones;
        this.metricas = metricas;
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
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

    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }

    public Metricas getMetricas() {
        return metricas;
    }

    public void setMetricas(Metricas metricas) {
        this.metricas = metricas;
    }

    public Integer getTiempoProcesamientoMs() {
        return tiempoProcesamientoMs;
    }

    public void setTiempoProcesamientoMs(Integer tiempoProcesamientoMs) {
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
    }
}
