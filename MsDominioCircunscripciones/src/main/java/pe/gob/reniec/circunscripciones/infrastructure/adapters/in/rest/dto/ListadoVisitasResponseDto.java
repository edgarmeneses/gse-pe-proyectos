package pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto;

public class ListadoVisitasResponseDto {

    private Boolean success;
    private ListadoDataDto data;
    private MetadataDto metadata;

    public ListadoVisitasResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ListadoDataDto getData() {
        return data;
    }

    public void setData(ListadoDataDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public static class ListadoDataDto {
        private String listadoId;
        private String cronogramaId;
        private String fechaGeneracion;
        private String tipoListado;
        private Object estadisticas;
        private Object equiposGenerados;
        private Object documentosGenerados;
        private Object actasVirtualesGeneradas;
        private Object links;

        public String getListadoId() {
            return listadoId;
        }

        public void setListadoId(String listadoId) {
            this.listadoId = listadoId;
        }

        public String getCronogramaId() {
            return cronogramaId;
        }

        public void setCronogramaId(String cronogramaId) {
            this.cronogramaId = cronogramaId;
        }

        public String getFechaGeneracion() {
            return fechaGeneracion;
        }

        public void setFechaGeneracion(String fechaGeneracion) {
            this.fechaGeneracion = fechaGeneracion;
        }

        public String getTipoListado() {
            return tipoListado;
        }

        public void setTipoListado(String tipoListado) {
            this.tipoListado = tipoListado;
        }

        public Object getEstadisticas() {
            return estadisticas;
        }

        public void setEstadisticas(Object estadisticas) {
            this.estadisticas = estadisticas;
        }

        public Object getEquiposGenerados() {
            return equiposGenerados;
        }

        public void setEquiposGenerados(Object equiposGenerados) {
            this.equiposGenerados = equiposGenerados;
        }

        public Object getDocumentosGenerados() {
            return documentosGenerados;
        }

        public void setDocumentosGenerados(Object documentosGenerados) {
            this.documentosGenerados = documentosGenerados;
        }

        public Object getActasVirtualesGeneradas() {
            return actasVirtualesGeneradas;
        }

        public void setActasVirtualesGeneradas(Object actasVirtualesGeneradas) {
            this.actasVirtualesGeneradas = actasVirtualesGeneradas;
        }

        public Object getLinks() {
            return links;
        }

        public void setLinks(Object links) {
            this.links = links;
        }
    }
}
