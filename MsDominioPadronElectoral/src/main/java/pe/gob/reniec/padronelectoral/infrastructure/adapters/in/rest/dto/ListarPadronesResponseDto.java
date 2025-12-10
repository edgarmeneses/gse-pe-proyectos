package pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ListarPadronesResponseDto {
    private Integer number;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
    private Boolean hasNext;
    private List<PadronResumenDto> contenido;

    public ListarPadronesResponseDto() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<PadronResumenDto> getContenido() {
        return contenido;
    }

    public void setContenido(List<PadronResumenDto> contenido) {
        this.contenido = contenido;
    }

    public static class PadronResumenDto {
        private String idPadron;
        private String tipoPadron;
        private String circunscripcion;
        private String tipoProceso;
        private String fechaCreacion;
        private Integer cantidadCiudadanos;

        public PadronResumenDto() {
        }

        public String getIdPadron() {
            return idPadron;
        }

        public void setIdPadron(String idPadron) {
            this.idPadron = idPadron;
        }

        public String getTipoPadron() {
            return tipoPadron;
        }

        public void setTipoPadron(String tipoPadron) {
            this.tipoPadron = tipoPadron;
        }

        public String getCircunscripcion() {
            return circunscripcion;
        }

        public void setCircunscripcion(String circunscripcion) {
            this.circunscripcion = circunscripcion;
        }

        public String getTipoProceso() {
            return tipoProceso;
        }

        public void setTipoProceso(String tipoProceso) {
            this.tipoProceso = tipoProceso;
        }

        public String getFechaCreacion() {
            return fechaCreacion;
        }

        public void setFechaCreacion(String fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }

        public Integer getCantidadCiudadanos() {
            return cantidadCiudadanos;
        }

        public void setCantidadCiudadanos(Integer cantidadCiudadanos) {
            this.cantidadCiudadanos = cantidadCiudadanos;
        }
    }
}
