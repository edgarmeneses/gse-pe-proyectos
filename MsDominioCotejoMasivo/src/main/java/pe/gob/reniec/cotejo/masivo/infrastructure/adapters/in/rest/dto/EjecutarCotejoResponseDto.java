package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

public class EjecutarCotejoResponseDto {
    private Boolean success;
    private EjecucionDataDto data;
    private MetadataDto metadata;

    public EjecutarCotejoResponseDto() {
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
    
    public static class EjecucionDataDto {
        private String ejecucionId;
        private String estadoProceso;
        private String mensajeProceso;
        private String codigoEstado;
        private String descripcionEstado;
        private Long totalRegistrosEntrada;
        private String fechaCreacion;

        public EjecucionDataDto() {
        }

        public String getEjecucionId() {
            return ejecucionId;
        }

        public void setEjecucionId(String ejecucionId) {
            this.ejecucionId = ejecucionId;
        }

        public String getEstadoProceso() {
            return estadoProceso;
        }

        public void setEstadoProceso(String estadoProceso) {
            this.estadoProceso = estadoProceso;
        }

        public String getMensajeProceso() {
            return mensajeProceso;
        }

        public void setMensajeProceso(String mensajeProceso) {
            this.mensajeProceso = mensajeProceso;
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
    }
}
