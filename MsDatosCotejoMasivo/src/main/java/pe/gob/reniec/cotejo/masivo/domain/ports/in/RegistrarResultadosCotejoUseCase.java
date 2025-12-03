package pe.gob.reniec.cotejo.masivo.domain.ports.in;

import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.domain.model.ResumenResultados;
import java.util.List;

public interface RegistrarResultadosCotejoUseCase {
    ResultadoRegistroCotejoBatch registrarBatch(String ejecucionId, List<ResultadoCotejo> resultados);
    
    public static class ResultadoRegistroCotejoBatch {
        private String ejecucionId;
        private Long totalResultadosRecibidos;
        private Long totalResultadosInsertados;
        private Long totalResultadosRechazados;
        private ResumenResultados resumenResultados;
        private List<ResultadoRechazado> resultadosRechazados;

        public ResultadoRegistroCotejoBatch() {
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

        public ResumenResultados getResumenResultados() {
            return resumenResultados;
        }

        public void setResumenResultados(ResumenResultados resumenResultados) {
            this.resumenResultados = resumenResultados;
        }

        public List<ResultadoRechazado> getResultadosRechazados() {
            return resultadosRechazados;
        }

        public void setResultadosRechazados(List<ResultadoRechazado> resultadosRechazados) {
            this.resultadosRechazados = resultadosRechazados;
        }
    }

    public static class ResultadoRechazado {
        private String registroEntradaId;
        private String motivoRechazo;

        public ResultadoRechazado() {
        }

        public ResultadoRechazado(String registroEntradaId, String motivoRechazo) {
            this.registroEntradaId = registroEntradaId;
            this.motivoRechazo = motivoRechazo;
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
