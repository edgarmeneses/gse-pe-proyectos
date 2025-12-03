package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad que representa el resultado de una evaluación de documentos
 */
public class EvaluacionDocumento {
    private String evaluacionId;
    private String solicitudId;
    private String tramiteId;
    private LocalDateTime fechaEvaluacion;
    private String modeloIAUtilizado;
    private Long tiempoProcesamientoMs;
    private ResultadoGeneral resultadoGeneral;
    private List<DocumentoEvaluado> documentosEvaluados;
    private List<AccionRecomendada> accionesRecomendadas;

    public EvaluacionDocumento() {
    }

    public String getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(String evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(String tramiteId) {
        this.tramiteId = tramiteId;
    }

    public LocalDateTime getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDateTime fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getModeloIAUtilizado() {
        return modeloIAUtilizado;
    }

    public void setModeloIAUtilizado(String modeloIAUtilizado) {
        this.modeloIAUtilizado = modeloIAUtilizado;
    }

    public Long getTiempoProcesamientoMs() {
        return tiempoProcesamientoMs;
    }

    public void setTiempoProcesamientoMs(Long tiempoProcesamientoMs) {
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
    }

    public ResultadoGeneral getResultadoGeneral() {
        return resultadoGeneral;
    }

    public void setResultadoGeneral(ResultadoGeneral resultadoGeneral) {
        this.resultadoGeneral = resultadoGeneral;
    }

    public List<DocumentoEvaluado> getDocumentosEvaluados() {
        return documentosEvaluados;
    }

    public void setDocumentosEvaluados(List<DocumentoEvaluado> documentosEvaluados) {
        this.documentosEvaluados = documentosEvaluados;
    }

    public List<AccionRecomendada> getAccionesRecomendadas() {
        return accionesRecomendadas;
    }

    public void setAccionesRecomendadas(List<AccionRecomendada> accionesRecomendadas) {
        this.accionesRecomendadas = accionesRecomendadas;
    }
}
