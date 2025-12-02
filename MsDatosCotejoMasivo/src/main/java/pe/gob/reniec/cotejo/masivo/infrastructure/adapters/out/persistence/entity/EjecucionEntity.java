package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class EjecucionEntity {
    private UUID ejecucionId;
    private UUID solicitudId;
    private String codigoOrganizacion;
    private String nombreOrganizacion;
    private String codigoEnvio;
    private String numeroLote;
    private String codigoEstado;
    private String descripcionEstado;
    private Integer totalRegistrosEntrada;
    private Integer totalRegistrosProcesados;
    private Integer totalRegistrosCorrectos;
    private Integer totalRegistrosIncorrectos;
    private LocalDateTime fechaInicioProceso;
    private LocalDateTime fechaFinProceso;
    private String documentoSustento;
    private String observaciones;
    private String urlReporteGenerado;
    private String indicadorDomicilio;
    private String codigoPrograma;
    private Integer totalCorrectos;
    private Integer totalIncorrectos;
    private Integer totalNoEncontrados;
    private Integer totalFallecidos;
    private Integer totalRestringidos;
    private Integer totalCaducados;
    private Integer totalErrores;
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;
    private LocalDateTime fechaModificacion;
    private String usuarioModificacion;

    public EjecucionEntity() {
    }

    public UUID getEjecucionId() {
        return ejecucionId;
    }

    public void setEjecucionId(UUID ejecucionId) {
        this.ejecucionId = ejecucionId;
    }

    public UUID getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(UUID solicitudId) {
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

    public Integer getTotalRegistrosEntrada() {
        return totalRegistrosEntrada;
    }

    public void setTotalRegistrosEntrada(Integer totalRegistrosEntrada) {
        this.totalRegistrosEntrada = totalRegistrosEntrada;
    }

    public Integer getTotalRegistrosProcesados() {
        return totalRegistrosProcesados;
    }

    public void setTotalRegistrosProcesados(Integer totalRegistrosProcesados) {
        this.totalRegistrosProcesados = totalRegistrosProcesados;
    }

    public Integer getTotalRegistrosCorrectos() {
        return totalRegistrosCorrectos;
    }

    public void setTotalRegistrosCorrectos(Integer totalRegistrosCorrectos) {
        this.totalRegistrosCorrectos = totalRegistrosCorrectos;
    }

    public Integer getTotalRegistrosIncorrectos() {
        return totalRegistrosIncorrectos;
    }

    public void setTotalRegistrosIncorrectos(Integer totalRegistrosIncorrectos) {
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

    public Integer getTotalCorrectos() {
        return totalCorrectos;
    }

    public void setTotalCorrectos(Integer totalCorrectos) {
        this.totalCorrectos = totalCorrectos;
    }

    public Integer getTotalIncorrectos() {
        return totalIncorrectos;
    }

    public void setTotalIncorrectos(Integer totalIncorrectos) {
        this.totalIncorrectos = totalIncorrectos;
    }

    public Integer getTotalNoEncontrados() {
        return totalNoEncontrados;
    }

    public void setTotalNoEncontrados(Integer totalNoEncontrados) {
        this.totalNoEncontrados = totalNoEncontrados;
    }

    public Integer getTotalFallecidos() {
        return totalFallecidos;
    }

    public void setTotalFallecidos(Integer totalFallecidos) {
        this.totalFallecidos = totalFallecidos;
    }

    public Integer getTotalRestringidos() {
        return totalRestringidos;
    }

    public void setTotalRestringidos(Integer totalRestringidos) {
        this.totalRestringidos = totalRestringidos;
    }

    public Integer getTotalCaducados() {
        return totalCaducados;
    }

    public void setTotalCaducados(Integer totalCaducados) {
        this.totalCaducados = totalCaducados;
    }

    public Integer getTotalErrores() {
        return totalErrores;
    }

    public void setTotalErrores(Integer totalErrores) {
        this.totalErrores = totalErrores;
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
