package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de Request: Calificar Documento
 */
public class CalificarDocumentoRequestDto {
    
    private String solicitudId;
    private String tramiteId;
    private String tipoTramite;
    private List<DocumentoDto> documentos;
    private ParametrosValidacionDto parametrosValidacion;
    private String usuarioSolicita;
    private String oficinaOrigen;
    private String fechaSolicitud;
    private String observaciones;
    
    public CalificarDocumentoRequestDto() {
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
    
    public List<DocumentoDto> getDocumentos() {
        return documentos;
    }
    
    public void setDocumentos(List<DocumentoDto> documentos) {
        this.documentos = documentos;
    }
    
    public ParametrosValidacionDto getParametrosValidacion() {
        return parametrosValidacion;
    }
    
    public void setParametrosValidacion(ParametrosValidacionDto parametrosValidacion) {
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
    
    public String getFechaSolicitud() {
        return fechaSolicitud;
    }
    
    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public static class DocumentoDto {
        private String documentoId;
        private String tipoDocumental;
        private String nombreArchivo;
        private String rutaGestorDocumental;
        private String hashSHA256;
        private String formatoDocumento;
        private Long tamanioBytes;
        private Boolean requiereValidacionIA;
        
        public DocumentoDto() {
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
    
    public static class ParametrosValidacionDto {
        private Double nivelPonderacionMinimo;
        private String modeloIA;
        private List<TipoObservacionDto> tiposObservacion;
        
        public ParametrosValidacionDto() {
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
        
        public List<TipoObservacionDto> getTiposObservacion() {
            return tiposObservacion;
        }
        
        public void setTiposObservacion(List<TipoObservacionDto> tiposObservacion) {
            this.tiposObservacion = tiposObservacion;
        }
    }
    
    public static class TipoObservacionDto {
        private String codigo;
        private String descripcion;
        
        public TipoObservacionDto() {
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
