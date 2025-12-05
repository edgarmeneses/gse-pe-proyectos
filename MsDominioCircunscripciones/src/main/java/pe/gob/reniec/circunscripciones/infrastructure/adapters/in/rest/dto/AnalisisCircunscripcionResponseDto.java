package pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto;

public class AnalisisCircunscripcionResponseDto {

    private Boolean success;
    private AnalisisDataDto data;
    private MetadataDto metadata;

    public AnalisisCircunscripcionResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public AnalisisDataDto getData() {
        return data;
    }

    public void setData(AnalisisDataDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public static class AnalisisDataDto {
        private String analisisId;
        private String cronogramaId;
        private String fechaAnalisis;
        private Object periodoAnalizado;
        private Object estadisticasGenerales;
        private Object circunscripcionesAfectadas;
        private Object alertasDetectadas;
        private Object recomendaciones;
        private String estadoAnalisis;
        private Integer tiempoProcesamientoMs;

        public String getAnalisisId() {
            return analisisId;
        }

        public void setAnalisisId(String analisisId) {
            this.analisisId = analisisId;
        }

        public String getCronogramaId() {
            return cronogramaId;
        }

        public void setCronogramaId(String cronogramaId) {
            this.cronogramaId = cronogramaId;
        }

        public String getFechaAnalisis() {
            return fechaAnalisis;
        }

        public void setFechaAnalisis(String fechaAnalisis) {
            this.fechaAnalisis = fechaAnalisis;
        }

        public Object getPeriodoAnalizado() {
            return periodoAnalizado;
        }

        public void setPeriodoAnalizado(Object periodoAnalizado) {
            this.periodoAnalizado = periodoAnalizado;
        }

        public Object getEstadisticasGenerales() {
            return estadisticasGenerales;
        }

        public void setEstadisticasGenerales(Object estadisticasGenerales) {
            this.estadisticasGenerales = estadisticasGenerales;
        }

        public Object getCircunscripcionesAfectadas() {
            return circunscripcionesAfectadas;
        }

        public void setCircunscripcionesAfectadas(Object circunscripcionesAfectadas) {
            this.circunscripcionesAfectadas = circunscripcionesAfectadas;
        }

        public Object getAlertasDetectadas() {
            return alertasDetectadas;
        }

        public void setAlertasDetectadas(Object alertasDetectadas) {
            this.alertasDetectadas = alertasDetectadas;
        }

        public Object getRecomendaciones() {
            return recomendaciones;
        }

        public void setRecomendaciones(Object recomendaciones) {
            this.recomendaciones = recomendaciones;
        }

        public String getEstadoAnalisis() {
            return estadoAnalisis;
        }

        public void setEstadoAnalisis(String estadoAnalisis) {
            this.estadoAnalisis = estadoAnalisis;
        }

        public Integer getTiempoProcesamientoMs() {
            return tiempoProcesamientoMs;
        }

        public void setTiempoProcesamientoMs(Integer tiempoProcesamientoMs) {
            this.tiempoProcesamientoMs = tiempoProcesamientoMs;
        }
    }
}
