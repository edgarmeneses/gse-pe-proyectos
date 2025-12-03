package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad de dominio: Evaluacion
 * Representa el resultado de la evaluación de documentos con IA
 */
public class Evaluacion {
    
    private String evaluacionId;
    private String solicitudId;
    private String tramiteId;
    private LocalDateTime fechaEvaluacion;
    private String modeloIAUtilizado;
    private Long tiempoProcesamientoMs;
    private ResultadoGeneral resultadoGeneral;
    private List<DocumentoEvaluado> documentosEvaluados;
    private List<AccionRecomendada> accionesRecomendadas;
    
    public Evaluacion() {
    }
    
    public Evaluacion(String evaluacionId, String solicitudId, String tramiteId, 
                      LocalDateTime fechaEvaluacion, String modeloIAUtilizado, 
                      Long tiempoProcesamientoMs, ResultadoGeneral resultadoGeneral, 
                      List<DocumentoEvaluado> documentosEvaluados, 
                      List<AccionRecomendada> accionesRecomendadas) {
        this.evaluacionId = evaluacionId;
        this.solicitudId = solicitudId;
        this.tramiteId = tramiteId;
        this.fechaEvaluacion = fechaEvaluacion;
        this.modeloIAUtilizado = modeloIAUtilizado;
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
        this.resultadoGeneral = resultadoGeneral;
        this.documentosEvaluados = documentosEvaluados;
        this.accionesRecomendadas = accionesRecomendadas;
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
    
    /**
     * Objeto de valor: ResultadoGeneral
     */
    public static class ResultadoGeneral {
        private String estado;
        private Double scorePromedio;
        private String nivelRiesgo;
        private Boolean alertaFraude;
        private Boolean requiereRevisionManual;
        private String observacionesGenerales;
        
        public ResultadoGeneral() {
        }
        
        public ResultadoGeneral(String estado, Double scorePromedio, String nivelRiesgo, 
                                Boolean alertaFraude, Boolean requiereRevisionManual, 
                                String observacionesGenerales) {
            this.estado = estado;
            this.scorePromedio = scorePromedio;
            this.nivelRiesgo = nivelRiesgo;
            this.alertaFraude = alertaFraude;
            this.requiereRevisionManual = requiereRevisionManual;
            this.observacionesGenerales = observacionesGenerales;
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
    
    /**
     * Objeto de valor: DocumentoEvaluado
     */
    public static class DocumentoEvaluado {
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
    
    /**
     * Objeto de valor: Observacion
     */
    public static class Observacion {
        private String codigo;
        private String descripcion;
        private String severidad;
        private List<String> evidencias;
        
        public Observacion() {
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
    
    /**
     * Objeto de valor: Metricas
     */
    public static class Metricas {
        private Double calidadImagen;
        private Double legibilidadTexto;
        private Double integridadEstructura;
        private Double confianzaOCR;
        
        public Metricas() {
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
    
    /**
     * Objeto de valor: AccionRecomendada
     */
    public static class AccionRecomendada {
        private String tipo;
        private String descripcion;
        private String prioridad;
        
        public AccionRecomendada() {
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
}
