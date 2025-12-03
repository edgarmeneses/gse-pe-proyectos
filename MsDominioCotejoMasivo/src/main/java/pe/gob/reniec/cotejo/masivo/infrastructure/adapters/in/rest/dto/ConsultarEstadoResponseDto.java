package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

public class ConsultarEstadoResponseDto {
    private Boolean success;
    private EstadoEjecucionDto data;
    private MetadataDto metadata;

    public ConsultarEstadoResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public EstadoEjecucionDto getData() {
        return data;
    }

    public void setData(EstadoEjecucionDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
    
    public static class EstadoEjecucionDto {
        private String ejecucionId;
        private String codigoEstado;
        private String descripcionEstado;
        private Long totalRegistrosEntrada;
        private Long totalRegistrosProcesados;
        private Long totalRegistrosCorrectos;
        private Long totalRegistrosIncorrectos;
        private String fechaInicioProceso;
        private String fechaFinProceso;
        private ResumenResultadosDto resumenResultados;

        public EstadoEjecucionDto() {
        }

        public String getEjecucionId() {
            return ejecucionId;
        }

        public void setEjecucionId(String ejecucionId) {
            this.ejecucionId = ejecucionId;
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

        public Long getTotalRegistrosProcesados() {
            return totalRegistrosProcesados;
        }

        public void setTotalRegistrosProcesados(Long totalRegistrosProcesados) {
            this.totalRegistrosProcesados = totalRegistrosProcesados;
        }

        public Long getTotalRegistrosCorrectos() {
            return totalRegistrosCorrectos;
        }

        public void setTotalRegistrosCorrectos(Long totalRegistrosCorrectos) {
            this.totalRegistrosCorrectos = totalRegistrosCorrectos;
        }

        public Long getTotalRegistrosIncorrectos() {
            return totalRegistrosIncorrectos;
        }

        public void setTotalRegistrosIncorrectos(Long totalRegistrosIncorrectos) {
            this.totalRegistrosIncorrectos = totalRegistrosIncorrectos;
        }

        public String getFechaInicioProceso() {
            return fechaInicioProceso;
        }

        public void setFechaInicioProceso(String fechaInicioProceso) {
            this.fechaInicioProceso = fechaInicioProceso;
        }

        public String getFechaFinProceso() {
            return fechaFinProceso;
        }

        public void setFechaFinProceso(String fechaFinProceso) {
            this.fechaFinProceso = fechaFinProceso;
        }

        public ResumenResultadosDto getResumenResultados() {
            return resumenResultados;
        }

        public void setResumenResultados(ResumenResultadosDto resumenResultados) {
            this.resumenResultados = resumenResultados;
        }
    }
    
    public static class ResumenResultadosDto {
        private Long totalCorrectos;
        private Long totalDniNoExiste;
        private Long totalDatosNoCoinciden;
        private Long totalErrores;
        private Double porcentajeExito;

        public ResumenResultadosDto() {
        }

        public Long getTotalCorrectos() {
            return totalCorrectos;
        }

        public void setTotalCorrectos(Long totalCorrectos) {
            this.totalCorrectos = totalCorrectos;
        }

        public Long getTotalDniNoExiste() {
            return totalDniNoExiste;
        }

        public void setTotalDniNoExiste(Long totalDniNoExiste) {
            this.totalDniNoExiste = totalDniNoExiste;
        }

        public Long getTotalDatosNoCoinciden() {
            return totalDatosNoCoinciden;
        }

        public void setTotalDatosNoCoinciden(Long totalDatosNoCoinciden) {
            this.totalDatosNoCoinciden = totalDatosNoCoinciden;
        }

        public Long getTotalErrores() {
            return totalErrores;
        }

        public void setTotalErrores(Long totalErrores) {
            this.totalErrores = totalErrores;
        }

        public Double getPorcentajeExito() {
            return porcentajeExito;
        }

        public void setPorcentajeExito(Double porcentajeExito) {
            this.porcentajeExito = porcentajeExito;
        }
    }
}
