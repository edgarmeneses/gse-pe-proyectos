package pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class MigracionesResponseDto {

    private Boolean success;
    private MigracionesDataDto data;
    private MetadataDto metadata;

    public MigracionesResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public MigracionesDataDto getData() {
        return data;
    }

    public void setData(MigracionesDataDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public static class MigracionesDataDto {
        private List<Object> migraciones;
        private PaginacionDto paginacion;

        public List<Object> getMigraciones() {
            return migraciones;
        }

        public void setMigraciones(List<Object> migraciones) {
            this.migraciones = migraciones;
        }

        public PaginacionDto getPaginacion() {
            return paginacion;
        }

        public void setPaginacion(PaginacionDto paginacion) {
            this.paginacion = paginacion;
        }
    }

    public static class PaginacionDto {
        private Integer paginaActual;
        private Integer tamanioPagina;
        private Integer totalRegistros;
        private Integer totalPaginas;

        public Integer getPaginaActual() {
            return paginaActual;
        }

        public void setPaginaActual(Integer paginaActual) {
            this.paginaActual = paginaActual;
        }

        public Integer getTamanioPagina() {
            return tamanioPagina;
        }

        public void setTamanioPagina(Integer tamanioPagina) {
            this.tamanioPagina = tamanioPagina;
        }

        public Integer getTotalRegistros() {
            return totalRegistros;
        }

        public void setTotalRegistros(Integer totalRegistros) {
            this.totalRegistros = totalRegistros;
        }

        public Integer getTotalPaginas() {
            return totalPaginas;
        }

        public void setTotalPaginas(Integer totalPaginas) {
            this.totalPaginas = totalPaginas;
        }
    }
}
