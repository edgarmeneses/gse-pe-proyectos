package pe.gob.reniec.cotejo.masivo.domain.ports.in;

import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import java.util.List;

public interface RegistrarRegistrosEntradaUseCase {
    ResultadoRegistroBatch registrarBatch(String ejecucionId, List<RegistroEntrada> registros);
    
    public static class ResultadoRegistroBatch {
        private String ejecucionId;
        private Long totalRegistrosRecibidos;
        private Long totalRegistrosInsertados;
        private Long totalRegistrosRechazados;
        private List<RegistroInsertado> registrosInsertados;
        private List<RegistroRechazado> registrosRechazados;

        public ResultadoRegistroBatch() {
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

        public List<RegistroInsertado> getRegistrosInsertados() {
            return registrosInsertados;
        }

        public void setRegistrosInsertados(List<RegistroInsertado> registrosInsertados) {
            this.registrosInsertados = registrosInsertados;
        }

        public List<RegistroRechazado> getRegistrosRechazados() {
            return registrosRechazados;
        }

        public void setRegistrosRechazados(List<RegistroRechazado> registrosRechazados) {
            this.registrosRechazados = registrosRechazados;
        }
    }

    public static class RegistroInsertado {
        private String registroEntradaId;
        private Long numeroSecuencia;
        private String numeroDni;

        public RegistroInsertado() {
        }

        public RegistroInsertado(String registroEntradaId, Long numeroSecuencia, String numeroDni) {
            this.registroEntradaId = registroEntradaId;
            this.numeroSecuencia = numeroSecuencia;
            this.numeroDni = numeroDni;
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

    public static class RegistroRechazado {
        private Long numeroSecuencia;
        private String numeroDni;
        private String motivoRechazo;

        public RegistroRechazado() {
        }

        public RegistroRechazado(Long numeroSecuencia, String numeroDni, String motivoRechazo) {
            this.numeroSecuencia = numeroSecuencia;
            this.numeroDni = numeroDni;
            this.motivoRechazo = motivoRechazo;
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
