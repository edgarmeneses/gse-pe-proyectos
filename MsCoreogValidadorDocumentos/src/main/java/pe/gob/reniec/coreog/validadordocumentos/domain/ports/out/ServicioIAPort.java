package pe.gob.reniec.coreog.validadordocumentos.domain.ports.out;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Evaluacion;
import java.util.List;

/**
 * Puerto de salida: Comunicación con el servicio de IA para evaluación de documentos
 * Este puerto permite interactuar con los modelos de inteligencia artificial
 */
public interface ServicioIAPort {
    
    /**
     * Evalúa documentos usando modelos de IA
     * 
     * @param solicitudEvaluacion Solicitud de evaluación con documentos y parámetros
     * @return Evaluación con los resultados del análisis de IA
     */
    Evaluacion evaluarDocumentos(SolicitudEvaluacionIA solicitudEvaluacion);
    
    /**
     * Compara una firma extraída con una firma de referencia
     * 
     * @param imagenFirmaDocumento Imagen de la firma del documento en Base64
     * @param imagenFirmaReferencia Imagen de la firma de referencia en Base64
     * @param umbralSimilitud Umbral mínimo de similitud
     * @return Resultado de la comparación
     */
    ResultadoComparacion compararFirma(String imagenFirmaDocumento, String imagenFirmaReferencia, Double umbralSimilitud);
    
    /**
     * Compara un sello extraído con un sello de referencia
     * 
     * @param imagenSelloDocumento Imagen del sello del documento en Base64
     * @param imagenSelloReferencia Imagen del sello de referencia en Base64
     * @param umbralSimilitud Umbral mínimo de similitud
     * @return Resultado de la comparación
     */
    ResultadoComparacion compararSello(String imagenSelloDocumento, String imagenSelloReferencia, Double umbralSimilitud);
    
    /**
     * Extrae la firma de un documento
     * 
     * @param contenidoDocumento Contenido del documento en bytes
     * @return Imagen de la firma en Base64
     */
    String extraerFirma(byte[] contenidoDocumento);
    
    /**
     * Extrae el sello de un documento
     * 
     * @param contenidoDocumento Contenido del documento en bytes
     * @return Imagen del sello en Base64
     */
    String extraerSello(byte[] contenidoDocumento);
    
    /**
     * Solicitud de evaluación con IA
     */
    class SolicitudEvaluacionIA {
        private String solicitudId;
        private String tramiteId;
        private List<DocumentoParaEvaluar> documentos;
        private String modeloIA;
        private Double nivelPonderacionMinimo;
        
        public SolicitudEvaluacionIA() {
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
        
        public List<DocumentoParaEvaluar> getDocumentos() {
            return documentos;
        }
        
        public void setDocumentos(List<DocumentoParaEvaluar> documentos) {
            this.documentos = documentos;
        }
        
        public String getModeloIA() {
            return modeloIA;
        }
        
        public void setModeloIA(String modeloIA) {
            this.modeloIA = modeloIA;
        }
        
        public Double getNivelPonderacionMinimo() {
            return nivelPonderacionMinimo;
        }
        
        public void setNivelPonderacionMinimo(Double nivelPonderacionMinimo) {
            this.nivelPonderacionMinimo = nivelPonderacionMinimo;
        }
    }
    
    /**
     * Documento para evaluar
     */
    class DocumentoParaEvaluar {
        private String documentoId;
        private String tipoDocumental;
        private byte[] contenido;
        private String formatoDocumento;
        
        public DocumentoParaEvaluar() {
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
        
        public byte[] getContenido() {
            return contenido;
        }
        
        public void setContenido(byte[] contenido) {
            this.contenido = contenido;
        }
        
        public String getFormatoDocumento() {
            return formatoDocumento;
        }
        
        public void setFormatoDocumento(String formatoDocumento) {
            this.formatoDocumento = formatoDocumento;
        }
    }
    
    /**
     * Resultado de comparación de firma/sello
     */
    class ResultadoComparacion {
        private Double scoreSimilitud;
        private String nivelConfianza;
        private Boolean coincide;
        private String observaciones;
        
        public ResultadoComparacion() {
        }
        
        public Double getScoreSimilitud() {
            return scoreSimilitud;
        }
        
        public void setScoreSimilitud(Double scoreSimilitud) {
            this.scoreSimilitud = scoreSimilitud;
        }
        
        public String getNivelConfianza() {
            return nivelConfianza;
        }
        
        public void setNivelConfianza(String nivelConfianza) {
            this.nivelConfianza = nivelConfianza;
        }
        
        public Boolean getCoincide() {
            return coincide;
        }
        
        public void setCoincide(Boolean coincide) {
            this.coincide = coincide;
        }
        
        public String getObservaciones() {
            return observaciones;
        }
        
        public void setObservaciones(String observaciones) {
            this.observaciones = observaciones;
        }
    }
}
