package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class RegistrarResultadosResponseDto {
    private Boolean success;
    private ResultadosBatchDataDto data;
    private MetadataDto metadata;
    private ErrorDto error;

    public RegistrarResultadosResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ResultadosBatchDataDto getData() {
        return data;
    }

    public void setData(ResultadosBatchDataDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public ErrorDto getError() {
        return error;
    }

    public void setError(ErrorDto error) {
        this.error = error;
    }

    public static class ResultadosBatchDataDto {
        private String ejecucionId;
        private Long totalResultadosRecibidos;
        private Long totalResultadosInsertados;
        private Long totalResultadosRechazados;
        private ResumenResultadosDto resumenResultados;
        private List<ResultadoRechazadoDto> resultadosRechazados;

        public ResultadosBatchDataDto() {
        }

        public String getEjecucionId() {
            return ejecucionId;
        }

        public void setEjecucionId(String ejecucionId) {
            this.ejecucionId = ejecucionId;
        }

        public Long getTotalResultadosRecibidos() {
            return totalResultadosRecibidos;
        }

        public void setTotalResultadosRecibidos(Long totalResultadosRecibidos) {
            this.totalResultadosRecibidos = totalResultadosRecibidos;
        }

        public Long getTotalResultadosInsertados() {
            return totalResultadosInsertados;
        }

        public void setTotalResultadosInsertados(Long totalResultadosInsertados) {
            this.totalResultadosInsertados = totalResultadosInsertados;
        }

        public Long getTotalResultadosRechazados() {
            return totalResultadosRechazados;
        }

        public void setTotalResultadosRechazados(Long totalResultadosRechazados) {
            this.totalResultadosRechazados = totalResultadosRechazados;
        }

        public ResumenResultadosDto getResumenResultados() {
            return resumenResultados;
        }

        public void setResumenResultados(ResumenResultadosDto resumenResultados) {
            this.resumenResultados = resumenResultados;
        }

        public List<ResultadoRechazadoDto> getResultadosRechazados() {
            return resultadosRechazados;
        }

        public void setResultadosRechazados(List<ResultadoRechazadoDto> resultadosRechazados) {
            this.resultadosRechazados = resultadosRechazados;
        }
    }

    public static class ResumenResultadosDto {
        private Long totalCorrectos;
        private Long totalIncorrectos;
        private Long totalNoEncontrados;
        private Long totalFallecidos;
        private Long totalRestringidos;
        private Long totalErrores;

        public ResumenResultadosDto() {
        }

        public Long getTotalCorrectos() {
            return totalCorrectos;
        }

        public void setTotalCorrectos(Long totalCorrectos) {
            this.totalCorrectos = totalCorrectos;
        }

        public Long getTotalIncorrectos() {
            return totalIncorrectos;
        }

        public void setTotalIncorrectos(Long totalIncorrectos) {
            this.totalIncorrectos = totalIncorrectos;
        }

        public Long getTotalNoEncontrados() {
            return totalNoEncontrados;
        }

        public void setTotalNoEncontrados(Long totalNoEncontrados) {
            this.totalNoEncontrados = totalNoEncontrados;
        }

        public Long getTotalFallecidos() {
            return totalFallecidos;
        }

        public void setTotalFallecidos(Long totalFallecidos) {
            this.totalFallecidos = totalFallecidos;
        }

        public Long getTotalRestringidos() {
            return totalRestringidos;
        }

        public void setTotalRestringidos(Long totalRestringidos) {
            this.totalRestringidos = totalRestringidos;
        }

        public Long getTotalErrores() {
            return totalErrores;
        }

        public void setTotalErrores(Long totalErrores) {
            this.totalErrores = totalErrores;
        }
    }

    public static class ResultadoRechazadoDto {
        private String registroEntradaId;
        private String motivoRechazo;

        public ResultadoRechazadoDto() {
        }

        public String getRegistroEntradaId() {
            return registroEntradaId;
        }

        public void setRegistroEntradaId(String registroEntradaId) {
            this.registroEntradaId = registroEntradaId;
        }

        public String getMotivoRechazo() {
            return motivoRechazo;
        }

        public void setMotivoRechazo(String motivoRechazo) {
            this.motivoRechazo = motivoRechazo;
        }
    }
}
