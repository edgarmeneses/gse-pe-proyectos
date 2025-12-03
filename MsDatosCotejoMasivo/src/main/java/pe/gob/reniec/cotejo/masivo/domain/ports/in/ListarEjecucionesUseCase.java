package pe.gob.reniec.cotejo.masivo.domain.ports.in;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import java.time.LocalDateTime;
import java.util.List;

public interface ListarEjecucionesUseCase {
    ResultadoPaginado listar(FiltrosEjecucion filtros, Paginacion paginacion);
    
    public static class FiltrosEjecucion {
        private String solicitudId;
        private String codigoOrganizacion;
        private String codigoEnvio;
        private String codigoEstado;
        private LocalDateTime fechaDesde;
        private LocalDateTime fechaHasta;

        public FiltrosEjecucion() {
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

        public String getCodigoEnvio() {
            return codigoEnvio;
        }

        public void setCodigoEnvio(String codigoEnvio) {
            this.codigoEnvio = codigoEnvio;
        }

        public String getCodigoEstado() {
            return codigoEstado;
        }

        public void setCodigoEstado(String codigoEstado) {
            this.codigoEstado = codigoEstado;
        }

        public LocalDateTime getFechaDesde() {
            return fechaDesde;
        }

        public void setFechaDesde(LocalDateTime fechaDesde) {
            this.fechaDesde = fechaDesde;
        }

        public LocalDateTime getFechaHasta() {
            return fechaHasta;
        }

        public void setFechaHasta(LocalDateTime fechaHasta) {
            this.fechaHasta = fechaHasta;
        }
    }

    public static class Paginacion {
        private Integer page;
        private Integer size;
        private String sort;
        private String direction;

        public Paginacion() {
        }

        public Paginacion(Integer page, Integer size, String sort, String direction) {
            this.page = page;
            this.size = size;
            this.sort = sort;
            this.direction = direction;
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

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }
    }

    public static class ResultadoPaginado {
        private List<Ejecucion> ejecuciones;
        private InfoPaginacion pagination;

        public ResultadoPaginado() {
        }

        public ResultadoPaginado(List<Ejecucion> ejecuciones, InfoPaginacion pagination) {
            this.ejecuciones = ejecuciones;
            this.pagination = pagination;
        }

        public List<Ejecucion> getEjecuciones() {
            return ejecuciones;
        }

        public void setEjecuciones(List<Ejecucion> ejecuciones) {
            this.ejecuciones = ejecuciones;
        }

        public InfoPaginacion getPagination() {
            return pagination;
        }

        public void setPagination(InfoPaginacion pagination) {
            this.pagination = pagination;
        }
    }

    public static class InfoPaginacion {
        private Integer page;
        private Integer size;
        private Long totalElements;
        private Integer totalPages;
        private Boolean first;
        private Boolean last;

        public InfoPaginacion() {
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
