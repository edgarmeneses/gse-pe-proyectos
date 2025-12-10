package pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class PadronElectoralResponseDto {
    private String idPadron;
    private List<CiudadanoDto> listaCiudadanos;
    private String tipoPadron;
    private String fechaCreacion;
    private String fechaActualizacion;

    public PadronElectoralResponseDto() {
    }

    public String getIdPadron() {
        return idPadron;
    }

    public void setIdPadron(String idPadron) {
        this.idPadron = idPadron;
    }

    public List<CiudadanoDto> getListaCiudadanos() {
        return listaCiudadanos;
    }

    public void setListaCiudadanos(List<CiudadanoDto> listaCiudadanos) {
        this.listaCiudadanos = listaCiudadanos;
    }

    public String getTipoPadron() {
        return tipoPadron;
    }

    public void setTipoPadron(String tipoPadron) {
        this.tipoPadron = tipoPadron;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
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
