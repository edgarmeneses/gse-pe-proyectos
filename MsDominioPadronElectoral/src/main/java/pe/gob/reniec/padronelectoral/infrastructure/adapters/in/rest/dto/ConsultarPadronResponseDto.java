package pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ConsultarPadronResponseDto {
    private PadronDto padron;
    private Integer number;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
    private Boolean hasNext;
    private List<CiudadanoDto> listaCiudadanos;

    public ConsultarPadronResponseDto() {
    }

    public PadronDto getPadron() {
        return padron;
    }

    public void setPadron(PadronDto padron) {
        this.padron = padron;
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

    public List<CiudadanoDto> getListaCiudadanos() {
        return listaCiudadanos;
    }

    public void setListaCiudadanos(List<CiudadanoDto> listaCiudadanos) {
        this.listaCiudadanos = listaCiudadanos;
    }

    public static class PadronDto {
        private String fechaCreacion;
        private List<ActualizacionPadronDto> actualizacionPadron;
        private String tipoPadron;
        private String tipoProceso;

        public PadronDto() {
        }

        public String getFechaCreacion() {
            return fechaCreacion;
        }

        public void setFechaCreacion(String fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }

        public List<ActualizacionPadronDto> getActualizacionPadron() {
            return actualizacionPadron;
        }

        public void setActualizacionPadron(List<ActualizacionPadronDto> actualizacionPadron) {
            this.actualizacionPadron = actualizacionPadron;
        }

        public String getTipoPadron() {
            return tipoPadron;
        }

        public void setTipoPadron(String tipoPadron) {
            this.tipoPadron = tipoPadron;
        }

        public String getTipoProceso() {
            return tipoProceso;
        }

        public void setTipoProceso(String tipoProceso) {
            this.tipoProceso = tipoProceso;
        }
    }

    public static class ActualizacionPadronDto {
        private String fechaActualizacion;
        private String usuarioResponsableId;
        private String informeFinalVerificacionDomicilioId;

        public ActualizacionPadronDto() {
        }

        public String getFechaActualizacion() {
            return fechaActualizacion;
        }

        public void setFechaActualizacion(String fechaActualizacion) {
            this.fechaActualizacion = fechaActualizacion;
        }

        public String getUsuarioResponsableId() {
            return usuarioResponsableId;
        }

        public void setUsuarioResponsableId(String usuarioResponsableId) {
            this.usuarioResponsableId = usuarioResponsableId;
        }

        public String getInformeFinalVerificacionDomicilioId() {
            return informeFinalVerificacionDomicilioId;
        }

        public void setInformeFinalVerificacionDomicilioId(String informeFinalVerificacionDomicilioId) {
            this.informeFinalVerificacionDomicilioId = informeFinalVerificacionDomicilioId;
        }
    }

    public static class CiudadanoDto {
        private String nombre;
        private String documento;
        private String direccion;

        public CiudadanoDto() {
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
    }
}
