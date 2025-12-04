package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto;

public class ConfirmarRevisionResponseDto {
    private Boolean success;
    private DataConfirmacionDto data;
    private MetadataDto metadata;

    public ConfirmarRevisionResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public DataConfirmacionDto getData() {
        return data;
    }

    public void setData(DataConfirmacionDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public static class DataConfirmacionDto {
        private String idPadron;
        private String tipoPadron;
        private String codigoCronogramaElectoral;
        private String estadoRevisionAnterior;
        private String estadoRevisionActual;
        private ConfirmacionDto confirmacion;
        private ResumenPaquetesDto resumenPaquetes;
        private SiguientePasoDto siguientePaso;
        private TrazabilidadDto trazabilidad;

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

        public String getCodigoCronogramaElectoral() {
            return codigoCronogramaElectoral;
        }

        public void setCodigoCronogramaElectoral(String codigoCronogramaElectoral) {
            this.codigoCronogramaElectoral = codigoCronogramaElectoral;
        }

        public String getEstadoRevisionAnterior() {
            return estadoRevisionAnterior;
        }

        public void setEstadoRevisionAnterior(String estadoRevisionAnterior) {
            this.estadoRevisionAnterior = estadoRevisionAnterior;
        }

        public String getEstadoRevisionActual() {
            return estadoRevisionActual;
        }

        public void setEstadoRevisionActual(String estadoRevisionActual) {
            this.estadoRevisionActual = estadoRevisionActual;
        }

        public ConfirmacionDto getConfirmacion() {
            return confirmacion;
        }

        public void setConfirmacion(ConfirmacionDto confirmacion) {
            this.confirmacion = confirmacion;
        }

        public ResumenPaquetesDto getResumenPaquetes() {
            return resumenPaquetes;
        }

        public void setResumenPaquetes(ResumenPaquetesDto resumenPaquetes) {
            this.resumenPaquetes = resumenPaquetes;
        }

        public SiguientePasoDto getSiguientePaso() {
            return siguientePaso;
        }

        public void setSiguientePaso(SiguientePasoDto siguientePaso) {
            this.siguientePaso = siguientePaso;
        }

        public TrazabilidadDto getTrazabilidad() {
            return trazabilidad;
        }

        public void setTrazabilidad(TrazabilidadDto trazabilidad) {
            this.trazabilidad = trazabilidad;
        }
    }
}
