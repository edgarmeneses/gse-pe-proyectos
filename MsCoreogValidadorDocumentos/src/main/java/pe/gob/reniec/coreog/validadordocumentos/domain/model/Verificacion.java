package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad de dominio: Verificacion
 * Representa el resultado de la verificación de firma y sello del registrador
 */
public class Verificacion {
    
    private String verificacionId;
    private String solicitudId;
    private String tramiteId;
    private String documentoId;
    private LocalDateTime fechaVerificacion;
    private String modeloIAUtilizado;
    private Long tiempoProcesamientoMs;
    private ResultadoGeneral resultadoGeneral;
    private VerificacionFirma verificacionFirma;
    private VerificacionSello verificacionSello;
    private VerificacionPeriodo verificacionPeriodo;
    private DatosRegistrador datosRegistradorVerificado;
    private List<Alerta> alertas;
    private List<AccionRecomendada> accionesRecomendadas;
    
    public Verificacion() {
    }
    
    public String getVerificacionId() {
        return verificacionId;
    }
    
    public void setVerificacionId(String verificacionId) {
        this.verificacionId = verificacionId;
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
    
    public LocalDateTime getFechaVerificacion() {
        return fechaVerificacion;
    }
    
    public void setFechaVerificacion(LocalDateTime fechaVerificacion) {
        this.fechaVerificacion = fechaVerificacion;
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
    
    public VerificacionFirma getVerificacionFirma() {
        return verificacionFirma;
    }
    
    public void setVerificacionFirma(VerificacionFirma verificacionFirma) {
        this.verificacionFirma = verificacionFirma;
    }
    
    public VerificacionSello getVerificacionSello() {
        return verificacionSello;
    }
    
    public void setVerificacionSello(VerificacionSello verificacionSello) {
        this.verificacionSello = verificacionSello;
    }
    
    public VerificacionPeriodo getVerificacionPeriodo() {
        return verificacionPeriodo;
    }
    
    public void setVerificacionPeriodo(VerificacionPeriodo verificacionPeriodo) {
        this.verificacionPeriodo = verificacionPeriodo;
    }
    
    public DatosRegistrador getDatosRegistradorVerificado() {
        return datosRegistradorVerificado;
    }
    
    public void setDatosRegistradorVerificado(DatosRegistrador datosRegistradorVerificado) {
        this.datosRegistradorVerificado = datosRegistradorVerificado;
    }
    
    public List<Alerta> getAlertas() {
        return alertas;
    }
    
    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
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
        private String estadoVerificacion;
        private Boolean firmaValida;
        private Boolean selloValido;
        private Boolean periodoValido;
        private Boolean requiereRevisionManual;
        private String observacionesGenerales;
        
        public ResultadoGeneral() {
        }
        
        public String getEstadoVerificacion() {
            return estadoVerificacion;
        }
        
        public void setEstadoVerificacion(String estadoVerificacion) {
            this.estadoVerificacion = estadoVerificacion;
        }
        
        public Boolean getFirmaValida() {
            return firmaValida;
        }
        
        public void setFirmaValida(Boolean firmaValida) {
            this.firmaValida = firmaValida;
        }
        
        public Boolean getSelloValido() {
            return selloValido;
        }
        
        public void setSelloValido(Boolean selloValido) {
            this.selloValido = selloValido;
        }
        
        public Boolean getPeriodoValido() {
            return periodoValido;
        }
        
        public void setPeriodoValido(Boolean periodoValido) {
            this.periodoValido = periodoValido;
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
     * Objeto de valor: VerificacionFirma
     */
    public static class VerificacionFirma {
        private String estadoFirma;
        private Double scoreSimilitud;
        private String nivelConfianza;
        private Boolean firmaEncontradaEnBD;
        private String imagenFirmaDocumento;
        private String imagenFirmaReferencia;
        private String observaciones;
        private MetricasFirma metricas;
        
        public VerificacionFirma() {
        }
        
        public String getEstadoFirma() {
            return estadoFirma;
        }
        
        public void setEstadoFirma(String estadoFirma) {
            this.estadoFirma = estadoFirma;
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
        
        public Boolean getFirmaEncontradaEnBD() {
            return firmaEncontradaEnBD;
        }
        
        public void setFirmaEncontradaEnBD(Boolean firmaEncontradaEnBD) {
            this.firmaEncontradaEnBD = firmaEncontradaEnBD;
        }
        
        public String getImagenFirmaDocumento() {
            return imagenFirmaDocumento;
        }
        
        public void setImagenFirmaDocumento(String imagenFirmaDocumento) {
            this.imagenFirmaDocumento = imagenFirmaDocumento;
        }
        
        public String getImagenFirmaReferencia() {
            return imagenFirmaReferencia;
        }
        
        public void setImagenFirmaReferencia(String imagenFirmaReferencia) {
            this.imagenFirmaReferencia = imagenFirmaReferencia;
        }
        
        public String getObservaciones() {
            return observaciones;
        }
        
        public void setObservaciones(String observaciones) {
            this.observaciones = observaciones;
        }
        
        public MetricasFirma getMetricas() {
            return metricas;
        }
        
        public void setMetricas(MetricasFirma metricas) {
            this.metricas = metricas;
        }
    }
    
    /**
     * Objeto de valor: MetricasFirma
     */
    public static class MetricasFirma {
        private Double similitudEstructural;
        private Double similitudTrazos;
        private Double calidadImagenExtraida;
        
        public MetricasFirma() {
        }
        
        public Double getSimilitudEstructural() {
            return similitudEstructural;
        }
        
        public void setSimilitudEstructural(Double similitudEstructural) {
            this.similitudEstructural = similitudEstructural;
        }
        
        public Double getSimilitudTrazos() {
            return similitudTrazos;
        }
        
        public void setSimilitudTrazos(Double similitudTrazos) {
            this.similitudTrazos = similitudTrazos;
        }
        
        public Double getCalidadImagenExtraida() {
            return calidadImagenExtraida;
        }
        
        public void setCalidadImagenExtraida(Double calidadImagenExtraida) {
            this.calidadImagenExtraida = calidadImagenExtraida;
        }
    }
    
    /**
     * Objeto de valor: VerificacionSello
     */
    public static class VerificacionSello {
        private String estadoSello;
        private Double scoreSimilitud;
        private String nivelConfianza;
        private Boolean selloEncontradoEnBD;
        private String imagenSelloDocumento;
        private String imagenSelloReferencia;
        private String observaciones;
        private MetricasSello metricas;
        
        public VerificacionSello() {
        }
        
        public String getEstadoSello() {
            return estadoSello;
        }
        
        public void setEstadoSello(String estadoSello) {
            this.estadoSello = estadoSello;
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
        
        public Boolean getSelloEncontradoEnBD() {
            return selloEncontradoEnBD;
        }
        
        public void setSelloEncontradoEnBD(Boolean selloEncontradoEnBD) {
            this.selloEncontradoEnBD = selloEncontradoEnBD;
        }
        
        public String getImagenSelloDocumento() {
            return imagenSelloDocumento;
        }
        
        public void setImagenSelloDocumento(String imagenSelloDocumento) {
            this.imagenSelloDocumento = imagenSelloDocumento;
        }
        
        public String getImagenSelloReferencia() {
            return imagenSelloReferencia;
        }
        
        public void setImagenSelloReferencia(String imagenSelloReferencia) {
            this.imagenSelloReferencia = imagenSelloReferencia;
        }
        
        public String getObservaciones() {
            return observaciones;
        }
        
        public void setObservaciones(String observaciones) {
            this.observaciones = observaciones;
        }
        
        public MetricasSello getMetricas() {
            return metricas;
        }
        
        public void setMetricas(MetricasSello metricas) {
            this.metricas = metricas;
        }
    }
    
    /**
     * Objeto de valor: MetricasSello
     */
    public static class MetricasSello {
        private Double similitudForma;
        private Double legibilidadTexto;
        private Double calidadImagenExtraida;
        
        public MetricasSello() {
        }
        
        public Double getSimilitudForma() {
            return similitudForma;
        }
        
        public void setSimilitudForma(Double similitudForma) {
            this.similitudForma = similitudForma;
        }
        
        public Double getLegibilidadTexto() {
            return legibilidadTexto;
        }
        
        public void setLegibilidadTexto(Double legibilidadTexto) {
            this.legibilidadTexto = legibilidadTexto;
        }
        
        public Double getCalidadImagenExtraida() {
            return calidadImagenExtraida;
        }
        
        public void setCalidadImagenExtraida(Double calidadImagenExtraida) {
            this.calidadImagenExtraida = calidadImagenExtraida;
        }
    }
    
    /**
     * Objeto de valor: VerificacionPeriodo
     */
    public static class VerificacionPeriodo {
        private String estadoPeriodo;
        private Boolean registradorEncontrado;
        private Boolean registradorHabilitado;
        private LocalDateTime fechaInscripcionActa;
        private PeriodoHabilitacion periodoHabilitacion;
        private String estadoRegistrador;
        private String observaciones;
        
        public VerificacionPeriodo() {
        }
        
        public String getEstadoPeriodo() {
            return estadoPeriodo;
        }
        
        public void setEstadoPeriodo(String estadoPeriodo) {
            this.estadoPeriodo = estadoPeriodo;
        }
        
        public Boolean getRegistradorEncontrado() {
            return registradorEncontrado;
        }
        
        public void setRegistradorEncontrado(Boolean registradorEncontrado) {
            this.registradorEncontrado = registradorEncontrado;
        }
        
        public Boolean getRegistradorHabilitado() {
            return registradorHabilitado;
        }
        
        public void setRegistradorHabilitado(Boolean registradorHabilitado) {
            this.registradorHabilitado = registradorHabilitado;
        }
        
        public LocalDateTime getFechaInscripcionActa() {
            return fechaInscripcionActa;
        }
        
        public void setFechaInscripcionActa(LocalDateTime fechaInscripcionActa) {
            this.fechaInscripcionActa = fechaInscripcionActa;
        }
        
        public PeriodoHabilitacion getPeriodoHabilitacion() {
            return periodoHabilitacion;
        }
        
        public void setPeriodoHabilitacion(PeriodoHabilitacion periodoHabilitacion) {
            this.periodoHabilitacion = periodoHabilitacion;
        }
        
        public String getEstadoRegistrador() {
            return estadoRegistrador;
        }
        
        public void setEstadoRegistrador(String estadoRegistrador) {
            this.estadoRegistrador = estadoRegistrador;
        }
        
        public String getObservaciones() {
            return observaciones;
        }
        
        public void setObservaciones(String observaciones) {
            this.observaciones = observaciones;
        }
    }
    
    /**
     * Objeto de valor: PeriodoHabilitacion
     */
    public static class PeriodoHabilitacion {
        private LocalDateTime fechaInicio;
        private LocalDateTime fechaFin;
        private String codigoLocal;
        private String nombreOficina;
        
        public PeriodoHabilitacion() {
        }
        
        public LocalDateTime getFechaInicio() {
            return fechaInicio;
        }
        
        public void setFechaInicio(LocalDateTime fechaInicio) {
            this.fechaInicio = fechaInicio;
        }
        
        public LocalDateTime getFechaFin() {
            return fechaFin;
        }
        
        public void setFechaFin(LocalDateTime fechaFin) {
            this.fechaFin = fechaFin;
        }
        
        public String getCodigoLocal() {
            return codigoLocal;
        }
        
        public void setCodigoLocal(String codigoLocal) {
            this.codigoLocal = codigoLocal;
        }
        
        public String getNombreOficina() {
            return nombreOficina;
        }
        
        public void setNombreOficina(String nombreOficina) {
            this.nombreOficina = nombreOficina;
        }
    }
    
    /**
     * Objeto de valor: DatosRegistrador
     */
    public static class DatosRegistrador {
        private String numeroDniRegistrador;
        private String idUsuario;
        private String nombreCompleto;
        private String codigoLocal;
        private String nombreOficina;
        private String estadoActual;
        
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
        
        public String getNombreCompleto() {
            return nombreCompleto;
        }
        
        public void setNombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
        }
        
        public String getCodigoLocal() {
            return codigoLocal;
        }
        
        public void setCodigoLocal(String codigoLocal) {
            this.codigoLocal = codigoLocal;
        }
        
        public String getNombreOficina() {
            return nombreOficina;
        }
        
        public void setNombreOficina(String nombreOficina) {
            this.nombreOficina = nombreOficina;
        }
        
        public String getEstadoActual() {
            return estadoActual;
        }
        
        public void setEstadoActual(String estadoActual) {
            this.estadoActual = estadoActual;
        }
    }
    
    /**
     * Objeto de valor: Alerta
     */
    public static class Alerta {
        private String codigo;
        private String tipo;
        private String descripcion;
        private String severidad;
        
        public Alerta() {
        }
        
        public String getCodigo() {
            return codigo;
        }
        
        public void setCodigo(String codigo) {
            this.codigo = codigo;
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
        
        public String getSeveridad() {
            return severidad;
        }
        
        public void setSeveridad(String severidad) {
            this.severidad = severidad;
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
