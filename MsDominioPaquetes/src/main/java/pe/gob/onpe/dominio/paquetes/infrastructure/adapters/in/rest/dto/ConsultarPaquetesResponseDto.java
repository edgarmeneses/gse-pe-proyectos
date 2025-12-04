package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ConsultarPaquetesResponseDto {
    private Boolean success;
    private DataConsultaDto data;
    private MetadataDto metadata;

    public ConsultarPaquetesResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public DataConsultaDto getData() {
        return data;
    }

    public void setData(DataConsultaDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public static class DataConsultaDto {
        private List<PaqueteElectoralDto> paquetes;
        private ResumenPaquetesDto resumen;
        private PaginacionDto paginacion;

        public List<PaqueteElectoralDto> getPaquetes() {
            return paquetes;
        }

        public void setPaquetes(List<PaqueteElectoralDto> paquetes) {
            this.paquetes = paquetes;
        }

        public ResumenPaquetesDto getResumen() {
            return resumen;
        }

        public void setResumen(ResumenPaquetesDto resumen) {
            this.resumen = resumen;
        }

        public PaginacionDto getPaginacion() {
            return paginacion;
        }

        public void setPaginacion(PaginacionDto paginacion) {
            this.paginacion = paginacion;
        }
    }
}
