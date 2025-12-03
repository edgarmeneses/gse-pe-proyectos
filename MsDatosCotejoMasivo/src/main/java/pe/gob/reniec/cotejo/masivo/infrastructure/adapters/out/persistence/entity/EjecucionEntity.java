package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

public class EjecucionEntity {
    private String ejecucionId;
    private String solicitudId;
    private String codigoOrganizacion;
    private String nombreOrganizacion;
    private String codigoEnvio;
    private String numeroLote;
    private String codigoEstado;
    private String descripcionEstado;
    private Long totalRegistrosEntrada;
    private Long totalRegistrosProcesados;
    private Long totalRegistrosCorrectos;
    private Long totalRegistrosIncorrectos;
    private LocalDateTime fechaInicioProceso;
    private LocalDateTime fechaFinProceso;
    private String documentoSustento;
    private String observaciones;
    private String urlReporteGenerado;
    private String indicadorDomicilio;
    private String codigoPrograma;
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;
    private LocalDateTime fechaModificacion;
    private String usuarioModificacion;

    public EjecucionEntity() {
    }

    public String getEjecucionId() {
        return ejecucionId;
    }

    public void setEjecucionId(String ejecucionId) {
        this.ejecucionId = ejecucionId;
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getCodigoOrganizacion() {
        return codigoOrganizacion;
    }

    public void setCodigoOrganizacion(String codigoOrganizacion) {
        this.codigoOrganizacion = codigoOrganizacion;
    }

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public String getCodigoEnvio() {
        return codigoEnvio;
    }

    public void setCodigoEnvio(String codigoEnvio) {
        this.codigoEnvio = codigoEnvio;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public Long getTotalRegistrosEntrada() {
        return totalRegistrosEntrada;
    }

    public void setTotalRegistrosEntrada(Long totalRegistrosEntrada) {
        this.totalRegistrosEntrada = totalRegistrosEntrada;
    }

    public Long getTotalRegistrosProcesados() {
        return totalRegistrosProcesados;
    }

    public void setTotalRegistrosProcesados(Long totalRegistrosProcesados) {
        this.totalRegistrosProcesados = totalRegistrosProcesados;
    }

    public Long getTotalRegistrosCorrectos() {
        return totalRegistrosCorrectos;
    }

    public void setTotalRegistrosCorrectos(Long totalRegistrosCorrectos) {
        this.totalRegistrosCorrectos = totalRegistrosCorrectos;
    }

    public Long getTotalRegistrosIncorrectos() {
        return totalRegistrosIncorrectos;
    }

    public void setTotalRegistrosIncorrectos(Long totalRegistrosIncorrectos) {
        this.totalRegistrosIncorrectos = totalRegistrosIncorrectos;
    }

    public LocalDateTime getFechaInicioProceso() {
        return fechaInicioProceso;
    }

    public void setFechaInicioProceso(LocalDateTime fechaInicioProceso) {
        this.fechaInicioProceso = fechaInicioProceso;
    }

    public LocalDateTime getFechaFinProceso() {
        return fechaFinProceso;
    }

    public void setFechaFinProceso(LocalDateTime fechaFinProceso) {
        this.fechaFinProceso = fechaFinProceso;
    }

    public String getDocumentoSustento() {
        return documentoSustento;
    }

    public void setDocumentoSustento(String documentoSustento) {
        this.documentoSustento = documentoSustento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUrlReporteGenerado() {
        return urlReporteGenerado;
    }

    public void setUrlReporteGenerado(String urlReporteGenerado) {
        this.urlReporteGenerado = urlReporteGenerado;
    }

    public String getIndicadorDomicilio() {
        return indicadorDomicilio;
    }

    public void setIndicadorDomicilio(String indicadorDomicilio) {
        this.indicadorDomicilio = indicadorDomicilio;
    }

    public String getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(String codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
