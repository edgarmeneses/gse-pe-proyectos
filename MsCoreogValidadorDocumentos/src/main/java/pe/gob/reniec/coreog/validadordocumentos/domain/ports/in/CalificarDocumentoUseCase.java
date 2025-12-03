package pe.gob.reniec.coreog.validadordocumentos.domain.ports.in;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Evaluacion;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Puerto de entrada: Caso de uso para calificar documentos con IA
 */
public interface CalificarDocumentoUseCase {
    
    /**
     * Ejecuta la calificación de documentos digitales con modelos de IA
     * 
     * @param comando Comando con los datos necesarios para la calificación
     * @return Evaluacion con los resultados de la calificación
     */
    Evaluacion ejecutar(CalificarDocumentoCommand comando);
    
    /**
     * Comando para la calificación de documentos
     */
    class CalificarDocumentoCommand {
        private String solicitudId;
        private String tramiteId;
        private String tipoTramite;
        private List<DocumentoInput> documentos;
        private ParametrosValidacion parametrosValidacion;
        private String usuarioSolicita;
        private String oficinaOrigen;
        private LocalDateTime fechaSolicitud;
        private String observaciones;
        
        public CalificarDocumentoCommand() {
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
        
        public String getTipoTramite() {
            return tipoTramite;
        }
        
        public void setTipoTramite(String tipoTramite) {
            this.tipoTramite = tipoTramite;
        }
        
        public List<DocumentoInput> getDocumentos() {
            return documentos;
        }
        
        public void setDocumentos(List<DocumentoInput> documentos) {
            this.documentos = documentos;
        }
        
        public ParametrosValidacion getParametrosValidacion() {
            return parametrosValidacion;
        }
        
        public void setParametrosValidacion(ParametrosValidacion parametrosValidacion) {
            this.parametrosValidacion = parametrosValidacion;
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
        
        public LocalDateTime getFechaSolicitud() {
            return fechaSolicitud;
        }
        
        public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
            this.fechaSolicitud = fechaSolicitud;
        }
        
        public String getObservaciones() {
            return observaciones;
        }
        
        public void setObservaciones(String observaciones) {
            this.observaciones = observaciones;
        }
    }
    
    /**
     * Datos de entrada de un documento
     */
    class DocumentoInput {
        private String documentoId;
        private String tipoDocumental;
        private String nombreArchivo;
        private String rutaGestorDocumental;
        private String hashSHA256;
        private String formatoDocumento;
        private Long tamanioBytes;
        private Boolean requiereValidacionIA;
        
        public DocumentoInput() {
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
        
        public String getRutaGestorDocumental() {
            return rutaGestorDocumental;
        }
        
        public void setRutaGestorDocumental(String rutaGestorDocumental) {
            this.rutaGestorDocumental = rutaGestorDocumental;
        }
        
        public String getHashSHA256() {
            return hashSHA256;
        }
        
        public void setHashSHA256(String hashSHA256) {
            this.hashSHA256 = hashSHA256;
        }
        
        public String getFormatoDocumento() {
            return formatoDocumento;
        }
        
        public void setFormatoDocumento(String formatoDocumento) {
            this.formatoDocumento = formatoDocumento;
        }
        
        public Long getTamanioBytes() {
            return tamanioBytes;
        }
        
        public void setTamanioBytes(Long tamanioBytes) {
            this.tamanioBytes = tamanioBytes;
        }
        
        public Boolean getRequiereValidacionIA() {
            return requiereValidacionIA;
        }
        
        public void setRequiereValidacionIA(Boolean requiereValidacionIA) {
            this.requiereValidacionIA = requiereValidacionIA;
        }
    }
    
    /**
     * Parámetros de validación
     */
    class ParametrosValidacion {
        private Double nivelPonderacionMinimo;
        private String modeloIA;
        private List<TipoObservacion> tiposObservacion;
        
        public ParametrosValidacion() {
        }
        
        public Double getNivelPonderacionMinimo() {
            return nivelPonderacionMinimo;
        }
        
        public void setNivelPonderacionMinimo(Double nivelPonderacionMinimo) {
            this.nivelPonderacionMinimo = nivelPonderacionMinimo;
        }
        
        public String getModeloIA() {
            return modeloIA;
        }
        
        public void setModeloIA(String modeloIA) {
            this.modeloIA = modeloIA;
        }
        
        public List<TipoObservacion> getTiposObservacion() {
            return tiposObservacion;
        }
        
        public void setTiposObservacion(List<TipoObservacion> tiposObservacion) {
            this.tiposObservacion = tiposObservacion;
        }
    }
    
    /**
     * Tipo de observación
     */
    class TipoObservacion {
        private String codigo;
        private String descripcion;
        
        public TipoObservacion() {
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
    }
}
