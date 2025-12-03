package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class RegistrarRegistrosResponseDto {
    private Boolean success;
    private RegistrosBatchDataDto data;
    private MetadataDto metadata;
    private ErrorDto error;

    public RegistrarRegistrosResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public RegistrosBatchDataDto getData() {
        return data;
    }

    public void setData(RegistrosBatchDataDto data) {
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

    public static class RegistrosBatchDataDto {
        private String ejecucionId;
        private Long totalRegistrosRecibidos;
        private Long totalRegistrosInsertados;
        private Long totalRegistrosRechazados;
        private List<RegistroInsertadoDto> registrosInsertados;
        private List<RegistroRechazadoDto> registrosRechazados;

        public RegistrosBatchDataDto() {
        }

        public String getEjecucionId() {
            return ejecucionId;
        }

        public void setEjecucionId(String ejecucionId) {
            this.ejecucionId = ejecucionId;
        }

        public Long getTotalRegistrosRecibidos() {
            return totalRegistrosRecibidos;
        }

        public void setTotalRegistrosRecibidos(Long totalRegistrosRecibidos) {
            this.totalRegistrosRecibidos = totalRegistrosRecibidos;
        }

        public Long getTotalRegistrosInsertados() {
            return totalRegistrosInsertados;
        }

        public void setTotalRegistrosInsertados(Long totalRegistrosInsertados) {
            this.totalRegistrosInsertados = totalRegistrosInsertados;
        }

        public Long getTotalRegistrosRechazados() {
            return totalRegistrosRechazados;
        }

        public void setTotalRegistrosRechazados(Long totalRegistrosRechazados) {
            this.totalRegistrosRechazados = totalRegistrosRechazados;
        }

        public List<RegistroInsertadoDto> getRegistrosInsertados() {
            return registrosInsertados;
        }

        public void setRegistrosInsertados(List<RegistroInsertadoDto> registrosInsertados) {
            this.registrosInsertados = registrosInsertados;
        }

        public List<RegistroRechazadoDto> getRegistrosRechazados() {
            return registrosRechazados;
        }

        public void setRegistrosRechazados(List<RegistroRechazadoDto> registrosRechazados) {
            this.registrosRechazados = registrosRechazados;
        }
    }

    public static class RegistroInsertadoDto {
        private String registroEntradaId;
        private Long numeroSecuencia;
        private String numeroDni;

        public RegistroInsertadoDto() {
        }

        public String getRegistroEntradaId() {
            return registroEntradaId;
        }

        public void setRegistroEntradaId(String registroEntradaId) {
            this.registroEntradaId = registroEntradaId;
        }

        public Long getNumeroSecuencia() {
            return numeroSecuencia;
        }

        public void setNumeroSecuencia(Long numeroSecuencia) {
            this.numeroSecuencia = numeroSecuencia;
        }

        public String getNumeroDni() {
            return numeroDni;
        }

        public void setNumeroDni(String numeroDni) {
            this.numeroDni = numeroDni;
        }
    }

    public static class RegistroRechazadoDto {
        private Long numeroSecuencia;
        private String numeroDni;
        private String motivoRechazo;

        public RegistroRechazadoDto() {
        }

        public Long getNumeroSecuencia() {
            return numeroSecuencia;
        }

        public void setNumeroSecuencia(Long numeroSecuencia) {
            this.numeroSecuencia = numeroSecuencia;
        }

        public String getNumeroDni() {
            return numeroDni;
        }

        public void setNumeroDni(String numeroDni) {
            this.numeroDni = numeroDni;
        }

        public String getMotivoRechazo() {
            return motivoRechazo;
        }

        public void setMotivoRechazo(String motivoRechazo) {
            this.motivoRechazo = motivoRechazo;
        }
    }
}
