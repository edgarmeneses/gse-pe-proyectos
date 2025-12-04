package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto;

public class AprobarPaqueteResponseDto {
    private Boolean success;
    private DataAprobacionDto data;
    private MetadataDto metadata;

    public AprobarPaqueteResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public DataAprobacionDto getData() {
        return data;
    }

    public void setData(DataAprobacionDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public static class DataAprobacionDto {
        private String paqueteId;
        private String codigoPaquete;
        private String estadoAnterior;
        private String estadoActual;
        private AprobacionDto aprobacion;
        private InformacionPublicacionDto informacionPublicacion;
        private TrazabilidadDto trazabilidad;

        public String getPaqueteId() {
            return paqueteId;
        }

        public void setPaqueteId(String paqueteId) {
            this.paqueteId = paqueteId;
        }

        public String getCodigoPaquete() {
            return codigoPaquete;
        }

        public void setCodigoPaquete(String codigoPaquete) {
            this.codigoPaquete = codigoPaquete;
        }

        public String getEstadoAnterior() {
            return estadoAnterior;
        }

        public void setEstadoAnterior(String estadoAnterior) {
            this.estadoAnterior = estadoAnterior;
        }

        public String getEstadoActual() {
            return estadoActual;
        }

        public void setEstadoActual(String estadoActual) {
            this.estadoActual = estadoActual;
        }

        public AprobacionDto getAprobacion() {
            return aprobacion;
        }

        public void setAprobacion(AprobacionDto aprobacion) {
            this.aprobacion = aprobacion;
        }

        public InformacionPublicacionDto getInformacionPublicacion() {
            return informacionPublicacion;
        }

        public void setInformacionPublicacion(InformacionPublicacionDto informacionPublicacion) {
            this.informacionPublicacion = informacionPublicacion;
        }

        public TrazabilidadDto getTrazabilidad() {
            return trazabilidad;
        }

        public void setTrazabilidad(TrazabilidadDto trazabilidad) {
            this.trazabilidad = trazabilidad;
        }
    }
}
