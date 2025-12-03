package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO de Request: Verificar Firma del Registrador
 */
public class VerificarFirmaRegistradorRequestDto {
    
    private String solicitudId;
    private String tramiteId;
    private String documentoId;
    private String tipoActa;
    private String rutaGestorDocumental;
    private String hashSHA256;
    private DatosRegistradorDto datosRegistrador;
    private DatosActaDto datosActa;
    private ParametrosVerificacionDto parametrosVerificacion;
    private String usuarioSolicita;
    private String oficinaOrigen;
    private String fechaSolicitud;
    private String observaciones;
    
    public VerificarFirmaRegistradorRequestDto() {
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
    
    public String getDocumentoId() {
        return documentoId;
    }
    
    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }
    
    public String getTipoActa() {
        return tipoActa;
    }
    
    public void setTipoActa(String tipoActa) {
        this.tipoActa = tipoActa;
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
    
    public DatosRegistradorDto getDatosRegistrador() {
        return datosRegistrador;
    }
    
    public void setDatosRegistrador(DatosRegistradorDto datosRegistrador) {
        this.datosRegistrador = datosRegistrador;
    }
    
    public DatosActaDto getDatosActa() {
        return datosActa;
    }
    
    public void setDatosActa(DatosActaDto datosActa) {
        this.datosActa = datosActa;
    }
    
    public ParametrosVerificacionDto getParametrosVerificacion() {
        return parametrosVerificacion;
    }
    
    public void setParametrosVerificacion(ParametrosVerificacionDto parametrosVerificacion) {
        this.parametrosVerificacion = parametrosVerificacion;
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
    
    public static class DatosRegistradorDto {
        private String numeroDniRegistrador;
        private String idUsuario;
        private String primerApellido;
        private String segundoApellido;
        private String prenombres;
        private String codigoLocal;
        
        public DatosRegistradorDto() {
        }
        
        public String getNumeroDniRegistrador() {
            return numeroDniRegistrador;
        }
        
        public void setNumeroDniRegistrador(String numeroDniRegistrador) {
            this.numeroDniRegistrador = numeroDniRegistrador;
        }
        
        public String getIdUsuario() {
            return idUsuario;
        }
        
        public void setIdUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
        }
        
        public String getPrimerApellido() {
            return primerApellido;
        }
        
        public void setPrimerApellido(String primerApellido) {
            this.primerApellido = primerApellido;
        }
        
        public String getSegundoApellido() {
            return segundoApellido;
        }
        
        public void setSegundoApellido(String segundoApellido) {
            this.segundoApellido = segundoApellido;
        }
        
        public String getPrenombres() {
            return prenombres;
        }
        
        public void setPrenombres(String prenombres) {
            this.prenombres = prenombres;
        }
        
        public String getCodigoLocal() {
            return codigoLocal;
        }
        
        public void setCodigoLocal(String codigoLocal) {
            this.codigoLocal = codigoLocal;
        }
    }
    
    public static class DatosActaDto {
        private String numeroActa;
        private Long anioActa;
        private String fechaInscripcion;
        private String oficinaRegistroCivil;
        
        public DatosActaDto() {
        }
        
        public String getNumeroActa() {
            return numeroActa;
        }
        
        public void setNumeroActa(String numeroActa) {
            this.numeroActa = numeroActa;
        }
        
        public Long getAnioActa() {
            return anioActa;
        }
        
        public void setAnioActa(Long anioActa) {
            this.anioActa = anioActa;
        }
        
        public String getFechaInscripcion() {
            return fechaInscripcion;
        }
        
        public void setFechaInscripcion(String fechaInscripcion) {
            this.fechaInscripcion = fechaInscripcion;
        }
        
        public String getOficinaRegistroCivil() {
            return oficinaRegistroCivil;
        }
        
        public void setOficinaRegistroCivil(String oficinaRegistroCivil) {
            this.oficinaRegistroCivil = oficinaRegistroCivil;
        }
    }
    
    public static class ParametrosVerificacionDto {
        private Double umbralSimilitudFirma;
        private Double umbralSimilitudSello;
        private String modeloIA;
        private Boolean incluirImagenesReferencia;
        
        public ParametrosVerificacionDto() {
        }
        
        public Double getUmbralSimilitudFirma() {
            return umbralSimilitudFirma;
        }
        
        public void setUmbralSimilitudFirma(Double umbralSimilitudFirma) {
            this.umbralSimilitudFirma = umbralSimilitudFirma;
        }
        
        public Double getUmbralSimilitudSello() {
            return umbralSimilitudSello;
        }
        
        public void setUmbralSimilitudSello(Double umbralSimilitudSello) {
            this.umbralSimilitudSello = umbralSimilitudSello;
        }
        
        public String getModeloIA() {
            return modeloIA;
        }
        
        public void setModeloIA(String modeloIA) {
            this.modeloIA = modeloIA;
        }
        
        public Boolean getIncluirImagenesReferencia() {
            return incluirImagenesReferencia;
        }
        
        public void setIncluirImagenesReferencia(Boolean incluirImagenesReferencia) {
            this.incluirImagenesReferencia = incluirImagenesReferencia;
        }
    }
}
