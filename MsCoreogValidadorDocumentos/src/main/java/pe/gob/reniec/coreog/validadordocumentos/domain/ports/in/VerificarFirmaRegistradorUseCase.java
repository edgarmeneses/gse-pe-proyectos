package pe.gob.reniec.coreog.validadordocumentos.domain.ports.in;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Verificacion;
import java.time.LocalDateTime;

/**
 * Puerto de entrada: Caso de uso para verificar firma del registrador
 */
public interface VerificarFirmaRegistradorUseCase {
    
    /**
     * Ejecuta la verificación de firma y sello del registrador civil
     * 
     * @param comando Comando con los datos necesarios para la verificación
     * @return Verificacion con los resultados de la verificación
     */
    Verificacion ejecutar(VerificarFirmaRegistradorCommand comando);
    
    /**
     * Comando para la verificación de firma del registrador
     */
    class VerificarFirmaRegistradorCommand {
        private String solicitudId;
        private String tramiteId;
        private String documentoId;
        private String tipoActa;
        private String rutaGestorDocumental;
        private String hashSHA256;
        private DatosRegistrador datosRegistrador;
        private DatosActa datosActa;
        private ParametrosVerificacion parametrosVerificacion;
        private String usuarioSolicita;
        private String oficinaOrigen;
        private LocalDateTime fechaSolicitud;
        private String observaciones;
        
        public VerificarFirmaRegistradorCommand() {
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
        
        public DatosRegistrador getDatosRegistrador() {
            return datosRegistrador;
        }
        
        public void setDatosRegistrador(DatosRegistrador datosRegistrador) {
            this.datosRegistrador = datosRegistrador;
        }
        
        public DatosActa getDatosActa() {
            return datosActa;
        }
        
        public void setDatosActa(DatosActa datosActa) {
            this.datosActa = datosActa;
        }
        
        public ParametrosVerificacion getParametrosVerificacion() {
            return parametrosVerificacion;
        }
        
        public void setParametrosVerificacion(ParametrosVerificacion parametrosVerificacion) {
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
     * Datos del registrador
     */
    class DatosRegistrador {
        private String numeroDniRegistrador;
        private String idUsuario;
        private String primerApellido;
        private String segundoApellido;
        private String prenombres;
        private String codigoLocal;
        
        public DatosRegistrador() {
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
    
    /**
     * Datos del acta
     */
    class DatosActa {
        private String numeroActa;
        private Long anioActa;
        private LocalDateTime fechaInscripcion;
        private String oficinaRegistroCivil;
        
        public DatosActa() {
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
        
        public LocalDateTime getFechaInscripcion() {
            return fechaInscripcion;
        }
        
        public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
            this.fechaInscripcion = fechaInscripcion;
        }
        
        public String getOficinaRegistroCivil() {
            return oficinaRegistroCivil;
        }
        
        public void setOficinaRegistroCivil(String oficinaRegistroCivil) {
            this.oficinaRegistroCivil = oficinaRegistroCivil;
        }
    }
    
    /**
     * Parámetros de verificación
     */
    class ParametrosVerificacion {
        private Double umbralSimilitudFirma;
        private Double umbralSimilitudSello;
        private String modeloIA;
        private Boolean incluirImagenesReferencia;
        
        public ParametrosVerificacion() {
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
