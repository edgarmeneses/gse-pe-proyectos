package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.util.List;

/**
 * Objeto de valor que representa un documento evaluado
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
    private Long tiempoProcesamientoMs;

    public DocumentoEvaluado() {
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

    public Long getTiempoProcesamientoMs() {
        return tiempoProcesamientoMs;
    }

    public void setTiempoProcesamientoMs(Long tiempoProcesamientoMs) {
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
    }
}
