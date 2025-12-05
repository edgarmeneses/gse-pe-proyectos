package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de entrada para registrar una evaluación de documento.
 */
public class EvaluacionDocumentoRequestDto {

    private String evaluacionId;
    private String solicitudId;
    private String tramiteId;
    private String fechaEvaluacion;
    private String modeloIAUtilizado;
    private Integer tiempoProcesamientoMs;
    private ResultadoGeneralDto resultadoGeneral;
    private List<DocumentoEvaluadoDto> documentosEvaluados;
    private List<AccionRecomendadaDto> accionesRecomendadas;
    private String usuarioSolicita;
    private String oficinaOrigen;

    public EvaluacionDocumentoRequestDto() {
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

    public String getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(String fechaEvaluacion) {
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

    public ResultadoGeneralDto getResultadoGeneral() {
        return resultadoGeneral;
    }

    public void setResultadoGeneral(ResultadoGeneralDto resultadoGeneral) {
        this.resultadoGeneral = resultadoGeneral;
    }

    public List<DocumentoEvaluadoDto> getDocumentosEvaluados() {
        return documentosEvaluados;
    }

    public void setDocumentosEvaluados(List<DocumentoEvaluadoDto> documentosEvaluados) {
        this.documentosEvaluados = documentosEvaluados;
    }

    public List<AccionRecomendadaDto> getAccionesRecomendadas() {
        return accionesRecomendadas;
    }

    public void setAccionesRecomendadas(List<AccionRecomendadaDto> accionesRecomendadas) {
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
