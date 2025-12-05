package pe.gob.reniec.validadordocumentos.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Aggregate Root que representa una evaluación completa de documentos.
 * Gestiona el resultado de la evaluación técnica de documentos presentados en un trámite.
 */
public class EvaluacionDocumento {

    private String evaluacionId;
    private String solicitudId;
    private String tramiteId;
    private LocalDateTime fechaEvaluacion;
    private String modeloIAUtilizado;
    private Integer tiempoProcesamientoMs;
    private ResultadoGeneral resultadoGeneral;
    private List<DocumentoEvaluado> documentosEvaluados;
    private List<AccionRecomendada> accionesRecomendadas;
    private String usuarioSolicita;
    private String oficinaOrigen;

    public EvaluacionDocumento() {
    }

    public EvaluacionDocumento(String evaluacionId, String solicitudId, String tramiteId,
                              LocalDateTime fechaEvaluacion, String modeloIAUtilizado,
                              Integer tiempoProcesamientoMs, ResultadoGeneral resultadoGeneral,
                              List<DocumentoEvaluado> documentosEvaluados,
                              List<AccionRecomendada> accionesRecomendadas, String usuarioSolicita,
                              String oficinaOrigen) {
        this.evaluacionId = evaluacionId;
        this.solicitudId = solicitudId;
        this.tramiteId = tramiteId;
        this.fechaEvaluacion = fechaEvaluacion;
        this.modeloIAUtilizado = modeloIAUtilizado;
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
        this.resultadoGeneral = resultadoGeneral;
        this.documentosEvaluados = documentosEvaluados;
        this.accionesRecomendadas = accionesRecomendadas;
        this.usuarioSolicita = usuarioSolicita;
        this.oficinaOrigen = oficinaOrigen;
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

    public Integer getTiempoProcesamientoMs() {
        return tiempoProcesamientoMs;
    }

    public void setTiempoProcesamientoMs(Integer tiempoProcesamientoMs) {
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

    public String getUsuarioSolicita() {
        return usuarioSolicita;
    }

    public void setUsuarioSolicita(String usuarioSolicita) {
        this.usuarioSolicita = usuarioSolicita;
    }

    public String getOficinaOrigen() {
        return oficinaOrigen;
    }

    public void setOficinaOrigen(String oficinaOrigen) {
        this.oficinaOrigen = oficinaOrigen;
    }
}
