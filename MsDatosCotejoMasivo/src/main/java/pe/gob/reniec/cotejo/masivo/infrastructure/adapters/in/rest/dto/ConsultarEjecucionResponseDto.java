package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

public class ConsultarEjecucionResponseDto {
    private Boolean success;
    private EjecucionDetalleDto data;
    private MetadataDto metadata;
    private ErrorDto error;

    public ConsultarEjecucionResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public EjecucionDetalleDto getData() {
        return data;
    }

    public void setData(EjecucionDetalleDto data) {
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

    public static class EjecucionDetalleDto {
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
        private String fechaInicioProceso;
        private String fechaFinProceso;
        private String documentoSustento;
        private String observaciones;
        private String urlReporteGenerado;
        private String indicadorDomicilio;
        private String codigoPrograma;
        private ResumenResultadosDetalleDto resumenResultados;
        private String fechaCreacion;
        private String usuarioCreacion;
        private String fechaModificacion;
        private String usuarioModificacion;
        private LinksDto _links;

        public EjecucionDetalleDto() {
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

        public String getFechaInicioProceso() {
            return fechaInicioProceso;
        }

        public void setFechaInicioProceso(String fechaInicioProceso) {
            this.fechaInicioProceso = fechaInicioProceso;
        }

        public String getFechaFinProceso() {
            return fechaFinProceso;
        }

        public void setFechaFinProceso(String fechaFinProceso) {
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

        public ResumenResultadosDetalleDto getResumenResultados() {
            return resumenResultados;
        }

        public void setResumenResultados(ResumenResultadosDetalleDto resumenResultados) {
            this.resumenResultados = resumenResultados;
        }

        public String getFechaCreacion() {
            return fechaCreacion;
        }

        public void setFechaCreacion(String fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }

        public String getUsuarioCreacion() {
            return usuarioCreacion;
        }

        public void setUsuarioCreacion(String usuarioCreacion) {
            this.usuarioCreacion = usuarioCreacion;
        }

        public String getFechaModificacion() {
            return fechaModificacion;
        }

        public void setFechaModificacion(String fechaModificacion) {
            this.fechaModificacion = fechaModificacion;
        }

        public String getUsuarioModificacion() {
            return usuarioModificacion;
        }

        public void setUsuarioModificacion(String usuarioModificacion) {
            this.usuarioModificacion = usuarioModificacion;
        }

        public LinksDto get_links() {
            return _links;
        }

        public void set_links(LinksDto _links) {
            this._links = _links;
        }
    }

    public static class ResumenResultadosDetalleDto {
        private Long totalCorrectos;
        private Long totalIncorrectos;
        private Long totalNoEncontrados;
        private Long totalFallecidos;
        private Long totalRestringidos;
        private Long totalCaducados;
        private Long totalErrores;

        public ResumenResultadosDetalleDto() {
        }

        public Long getTotalCorrectos() {
            return totalCorrectos;
        }

        public void setTotalCorrectos(Long totalCorrectos) {
            this.totalCorrectos = totalCorrectos;
        }

        public Long getTotalIncorrectos() {
            return totalIncorrectos;
        }

        public void setTotalIncorrectos(Long totalIncorrectos) {
            this.totalIncorrectos = totalIncorrectos;
        }

        public Long getTotalNoEncontrados() {
            return totalNoEncontrados;
        }

        public void setTotalNoEncontrados(Long totalNoEncontrados) {
            this.totalNoEncontrados = totalNoEncontrados;
        }

        public Long getTotalFallecidos() {
            return totalFallecidos;
        }

        public void setTotalFallecidos(Long totalFallecidos) {
            this.totalFallecidos = totalFallecidos;
        }

        public Long getTotalRestringidos() {
            return totalRestringidos;
        }

        public void setTotalRestringidos(Long totalRestringidos) {
            this.totalRestringidos = totalRestringidos;
        }

        public Long getTotalCaducados() {
            return totalCaducados;
        }

        public void setTotalCaducados(Long totalCaducados) {
            this.totalCaducados = totalCaducados;
        }

        public Long getTotalErrores() {
            return totalErrores;
        }

        public void setTotalErrores(Long totalErrores) {
            this.totalErrores = totalErrores;
        }
    }

    public static class LinksDto {
        private String self;
        private String registros;
        private String resultados;
        private String actualizarEstado;
        private String solicitud;

        public LinksDto() {
        }

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getRegistros() {
            return registros;
        }

        public void setRegistros(String registros) {
            this.registros = registros;
        }

        public String getResultados() {
            return resultados;
        }

        public void setResultados(String resultados) {
            this.resultados = resultados;
        }

        public String getActualizarEstado() {
            return actualizarEstado;
        }

        public void setActualizarEstado(String actualizarEstado) {
            this.actualizarEstado = actualizarEstado;
        }

        public String getSolicitud() {
            return solicitud;
        }

        public void setSolicitud(String solicitud) {
            this.solicitud = solicitud;
        }
    }
}
