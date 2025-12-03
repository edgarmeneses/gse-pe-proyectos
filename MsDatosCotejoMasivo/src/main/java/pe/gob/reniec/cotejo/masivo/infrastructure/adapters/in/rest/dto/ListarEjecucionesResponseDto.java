package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ListarEjecucionesResponseDto {
    private Boolean success;
    private List<EjecucionListaDto> data;
    private PaginacionDto pagination;
    private MetadataDto metadata;
    private ErrorDto error;

    public ListarEjecucionesResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<EjecucionListaDto> getData() {
        return data;
    }

    public void setData(List<EjecucionListaDto> data) {
        this.data = data;
    }

    public PaginacionDto getPagination() {
        return pagination;
    }

    public void setPagination(PaginacionDto pagination) {
        this.pagination = pagination;
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

    public static class EjecucionListaDto {
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
        private String fechaCreacion;
        private String usuarioCreacion;

        public EjecucionListaDto() {
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
    }

    public static class PaginacionDto {
        private Integer page;
        private Integer size;
        private Long totalElements;
        private Integer totalPages;
        private Boolean first;
        private Boolean last;

        public PaginacionDto() {
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Long getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(Long totalElements) {
            this.totalElements = totalElements;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public Boolean getFirst() {
            return first;
        }

        public void setFirst(Boolean first) {
            this.first = first;
        }

        public Boolean getLast() {
            return last;
        }

        public void setLast(Boolean last) {
            this.last = last;
        }
    }
}
