package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de Response: Calificar Documento
 */
public class CalificarDocumentoResponseDto {
    
    private Boolean success;
    private DataDto data;
    private MetadataDto metadata;
    private ErrorDto error;
    
    public CalificarDocumentoResponseDto() {
    }
    
    public Boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    
    public DataDto getData() {
        return data;
    }
    
    public void setData(DataDto data) {
        this.data = data;
    }
    
    public MetadataDto getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
    
    public ErrorDto getError() {
        return error;
    }
    
    public void setError(ErrorDto error) {
        this.error = error;
    }
    
    public static class DataDto {
        private String evaluacionId;
        private String solicitudId;
        private String tramiteId;
        private String fechaEvaluacion;
        private String modeloIAUtilizado;
        private Long tiempoProcesamientoMs;
        private ResultadoGeneralDto resultadoGeneral;
        private List<DocumentoEvaluadoDto> documentosEvaluados;
        private List<AccionRecomendadaDto> accionesRecomendadas;
        
        public DataDto() {
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
        
        public Long getTiempoProcesamientoMs() {
            return tiempoProcesamientoMs;
        }
        
        public void setTiempoProcesamientoMs(Long tiempoProcesamientoMs) {
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
    }
    
    public static class ResultadoGeneralDto {
        private String estado;
        private Double scorePromedio;
        private String nivelRiesgo;
        private Boolean alertaFraude;
        private Boolean requiereRevisionManual;
        private String observacionesGenerales;
        
        public ResultadoGeneralDto() {
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
    
    public static class DocumentoEvaluadoDto {
        private String documentoId;
        private String tipoDocumental;
        private String nombreArchivo;
        private String estadoEvaluacion;
        private Double scoreConfiabilidad;
        private String nivelRiesgo;
        private Boolean alertaFraude;
        private List<ObservacionDto> observaciones;
        private MetricasDto metricas;
        private Long tiempoProcesamientoMs;
        
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
        
        public Long getTiempoProcesamientoMs() {
            return tiempoProcesamientoMs;
        }
        
        public void setTiempoProcesamientoMs(Long tiempoProcesamientoMs) {
            this.tiempoProcesamientoMs = tiempoProcesamientoMs;
        }
    }
    
    public static class ObservacionDto {
        private String codigo;
        private String descripcion;
        private String severidad;
        private List<String> evidencias;
        
        public ObservacionDto() {
        }
        
        public String getCodigo() {
            return codigo;
        }
        
        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }
        
        public String getDescripcion() {
            return descripcion;
        }
        
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
        
        public String getSeveridad() {
            return severidad;
        }
        
        public void setSeveridad(String severidad) {
            this.severidad = severidad;
        }
        
        public List<String> getEvidencias() {
            return evidencias;
        }
        
        public void setEvidencias(List<String> evidencias) {
            this.evidencias = evidencias;
        }
    }
    
    public static class MetricasDto {
        private Double calidadImagen;
        private Double legibilidadTexto;
        private Double integridadEstructura;
        private Double confianzaOCR;
        
        public MetricasDto() {
        }
        
        public Double getCalidadImagen() {
            return calidadImagen;
        }
        
        public void setCalidadImagen(Double calidadImagen) {
            this.calidadImagen = calidadImagen;
        }
        
        public Double getLegibilidadTexto() {
            return legibilidadTexto;
        }
        
        public void setLegibilidadTexto(Double legibilidadTexto) {
            this.legibilidadTexto = legibilidadTexto;
        }
        
        public Double getIntegridadEstructura() {
            return integridadEstructura;
        }
        
        public void setIntegridadEstructura(Double integridadEstructura) {
            this.integridadEstructura = integridadEstructura;
        }
        
        public Double getConfianzaOCR() {
            return confianzaOCR;
        }
        
        public void setConfianzaOCR(Double confianzaOCR) {
            this.confianzaOCR = confianzaOCR;
        }
    }
    
    public static class AccionRecomendadaDto {
        private String tipo;
        private String descripcion;
        private String prioridad;
        
        public AccionRecomendadaDto() {
        }
        
        public String getTipo() {
            return tipo;
        }
        
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        
        public String getDescripcion() {
            return descripcion;
        }
        
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
        
        public String getPrioridad() {
            return prioridad;
        }
        
        public void setPrioridad(String prioridad) {
            this.prioridad = prioridad;
        }
    }
    
    public static class MetadataDto {
        private String timestamp;
        private String correlationId;
        private String version;
        private String servidorProcesamiento;
        
        public MetadataDto() {
        }
        
        public String getTimestamp() {
            return timestamp;
        }
        
        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
        
        public String getCorrelationId() {
            return correlationId;
        }
        
        public void setCorrelationId(String correlationId) {
            this.correlationId = correlationId;
        }
        
        public String getVersion() {
            return version;
        }
        
        public void setVersion(String version) {
            this.version = version;
        }
        
        public String getServidorProcesamiento() {
            return servidorProcesamiento;
        }
        
        public void setServidorProcesamiento(String servidorProcesamiento) {
            this.servidorProcesamiento = servidorProcesamiento;
        }
    }
    
    public static class ErrorDto {
        private String tipo;
        private String titulo;
        private Integer estado;
        private List<DetalleErrorDto> errores;
        
        public ErrorDto() {
        }
        
        public String getTipo() {
            return tipo;
        }
        
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        
        public String getTitulo() {
            return titulo;
        }
        
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
        
        public Integer getEstado() {
            return estado;
        }
        
        public void setEstado(Integer estado) {
            this.estado = estado;
        }
        
        public List<DetalleErrorDto> getErrores() {
            return errores;
        }
        
        public void setErrores(List<DetalleErrorDto> errores) {
            this.errores = errores;
        }
    }
    
    public static class DetalleErrorDto {
        private String codigo;
        private String campo;
        private String detalleError;
        
        public DetalleErrorDto() {
        }
        
        public String getCodigo() {
            return codigo;
        }
        
        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }
        
        public String getCampo() {
            return campo;
        }
        
        public void setCampo(String campo) {
            this.campo = campo;
        }
        
        public String getDetalleError() {
            return detalleError;
        }
        
        public void setDetalleError(String detalleError) {
            this.detalleError = detalleError;
        }
    }
}
