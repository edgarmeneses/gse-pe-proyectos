package pe.gob.reniec.configuracion.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de respuesta - Consultar configuraciones por categoría
 * Endpoint: GET /api/v1/configuracion/MsDatosConfiguracion/categoria
 */
public class ConsultarCategoriaResponseDto {

    private BodyDto body;

    public ConsultarCategoriaResponseDto() {
    }

    public BodyDto getBody() {
        return body;
    }

    public void setBody(BodyDto body) {
        this.body = body;
    }

    public static class BodyDto {
        private String categoria;
        private Integer totalConfiguraciones;
        private List<ConfiguracionDto> configuraciones;
        private PaginationDto pagination;

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public Integer getTotalConfiguraciones() {
            return totalConfiguraciones;
        }

        public void setTotalConfiguraciones(Integer totalConfiguraciones) {
            this.totalConfiguraciones = totalConfiguraciones;
        }

        public List<ConfiguracionDto> getConfiguraciones() {
            return configuraciones;
        }

        public void setConfiguraciones(List<ConfiguracionDto> configuraciones) {
            this.configuraciones = configuraciones;
        }

        public PaginationDto getPagination() {
            return pagination;
        }

        public void setPagination(PaginationDto pagination) {
            this.pagination = pagination;
        }
    }

    public static class ConfiguracionDto {
        private String clave;
        private Object valor;
        private String tipoDato;
        private String unidad;
        private String descripcion;
        private Integer version;
        private String estado;

        public String getClave() {
            return clave;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public Object getValor() {
            return valor;
        }

        public void setValor(Object valor) {
            this.valor = valor;
        }

        public String getTipoDato() {
            return tipoDato;
        }

        public void setTipoDato(String tipoDato) {
            this.tipoDato = tipoDato;
        }

        public String getUnidad() {
            return unidad;
        }

        public void setUnidad(String unidad) {
            this.unidad = unidad;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }

    public static class PaginationDto {
        private Integer page;
        private Integer size;
        private Integer totalPages;
        private Integer totalElements;

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

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public Integer getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(Integer totalElements) {
            this.totalElements = totalElements;
        }
    }
}
