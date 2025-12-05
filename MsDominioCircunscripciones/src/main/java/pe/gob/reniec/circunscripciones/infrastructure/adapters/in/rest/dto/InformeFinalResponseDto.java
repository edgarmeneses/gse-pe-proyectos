package pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto;

public class InformeFinalResponseDto {

    private Boolean success;
    private InformeDataDto data;
    private MetadataDto metadata;

    public InformeFinalResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public InformeDataDto getData() {
        return data;
    }

    public void setData(InformeDataDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public static class InformeDataDto {
        private String informeId;
        private String cronogramaId;
        private String tipoInforme;
        private String fechaGeneracion;
        private Object circunscripcion;
        private Object estadisticas;
        private Object recomendaciones;
        private Object documentoGenerado;
        private String estadoInforme;
        private Boolean requiereAprobacion;
        private String proximoPaso;
        private Object links;

        public String getInformeId() {
            return informeId;
        }

        public void setInformeId(String informeId) {
            this.informeId = informeId;
        }

        public String getCronogramaId() {
            return cronogramaId;
        }

        public void setCronogramaId(String cronogramaId) {
            this.cronogramaId = cronogramaId;
        }

        public String getTipoInforme() {
            return tipoInforme;
        }

        public void setTipoInforme(String tipoInforme) {
            this.tipoInforme = tipoInforme;
        }

        public String getFechaGeneracion() {
            return fechaGeneracion;
        }

        public void setFechaGeneracion(String fechaGeneracion) {
            this.fechaGeneracion = fechaGeneracion;
        }

        public Object getCircunscripcion() {
            return circunscripcion;
        }

        public void setCircunscripcion(Object circunscripcion) {
            this.circunscripcion = circunscripcion;
        }

        public Object getEstadisticas() {
            return estadisticas;
        }

        public void setEstadisticas(Object estadisticas) {
            this.estadisticas = estadisticas;
        }

        public Object getRecomendaciones() {
            return recomendaciones;
        }

        public void setRecomendaciones(Object recomendaciones) {
            this.recomendaciones = recomendaciones;
        }

        public Object getDocumentoGenerado() {
            return documentoGenerado;
        }

        public void setDocumentoGenerado(Object documentoGenerado) {
            this.documentoGenerado = documentoGenerado;
        }

        public String getEstadoInforme() {
            return estadoInforme;
        }

        public void setEstadoInforme(String estadoInforme) {
            this.estadoInforme = estadoInforme;
        }

        public Boolean getRequiereAprobacion() {
            return requiereAprobacion;
        }

        public void setRequiereAprobacion(Boolean requiereAprobacion) {
            this.requiereAprobacion = requiereAprobacion;
        }

        public String getProximoPaso() {
            return proximoPaso;
        }

        public void setProximoPaso(String proximoPaso) {
            this.proximoPaso = proximoPaso;
        }

        public Object getLinks() {
            return links;
        }

        public void setLinks(Object links) {
            this.links = links;
        }
    }
}
