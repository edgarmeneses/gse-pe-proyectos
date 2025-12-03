package pe.gob.reniec.cotejo.masivo.domain.ports.out;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import java.util.List;

public interface EjecucionDataPort {
    Ejecucion crearEjecucion(Ejecucion ejecucion);
    
    ResultadoRegistroBatch registrarRegistros(String ejecucionId, List<RegistroEntrada> registros);
    
    ResultadoCotejoBatch registrarResultados(String ejecucionId, List<ResultadoCotejo> resultados);
    
    Ejecucion consultarEjecucion(String ejecucionId);
    
    List<ResultadoCotejo> obtenerResultados(String ejecucionId, String codigoResultado, Integer page, Integer size);
    
    public static class ResultadoRegistroBatch {
        private String ejecucionId;
        private Long totalRegistrosRecibidos;
        private Long totalRegistrosInsertados;
        private Long totalRegistrosRechazados;
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

        public List<RegistroRechazado> getRegistrosRechazados() {
            return registrosRechazados;
        }

        public void setRegistrosRechazados(List<RegistroRechazado> registrosRechazados) {
            this.registrosRechazados = registrosRechazados;
        }
    }
    
    public static class RegistroRechazado {
        private Long numeroSecuencia;
        private String numeroDni;
        private String motivoRechazo;

        public RegistroRechazado() {
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
    
    public static class ResultadoCotejoBatch {
        private String ejecucionId;
        private Long totalResultadosRecibidos;
        private Long totalResultadosInsertados;
        private Long totalResultadosRechazados;
        private List<ResultadoRechazado> resultadosRechazados;

        public ResultadoCotejoBatch() {
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
