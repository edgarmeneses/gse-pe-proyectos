package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

public class EjecucionResponseDto {
    private Boolean success;
    private EjecucionDataDto data;
    private MetadataDto metadata;
    private ErrorDto error;

    public EjecucionResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public EjecucionDataDto getData() {
        return data;
    }

    public void setData(EjecucionDataDto data) {
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

    public static class EjecucionDataDto {
        private String ejecucionId;
        private String solicitudId;
        private String codigoOrganizacion;
        private String nombreOrganizacion;
        private String codigoEnvio;
        private String numeroLote;
        private String codigoEstado;
        private String descripcionEstado;
        private Long totalRegistrosEntrada;
        private String fechaCreacion;
        private String usuarioCreacion;
        private LinksDto _links;

        public EjecucionDataDto() {
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

        public LinksDto get_links() {
            return _links;
        }

        public void set_links(LinksDto _links) {
            this._links = _links;
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
