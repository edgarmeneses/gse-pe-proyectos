package pe.gob.reniec.cotejo.masivo.domain.ports.in;

import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import java.util.List;

public interface ObtenerResultadosUseCase {
    ResultadoPaginado obtenerResultados(FiltrosResultados filtros);
    
    public static class FiltrosResultados {
        private String ejecucionId;
        private String codigoResultado;
        private Integer page;
        private Integer size;

        public FiltrosResultados() {
        }

        public FiltrosResultados(String ejecucionId) {
            this.ejecucionId = ejecucionId;
            this.page = 0;
            this.size = 100;
        }

        public String getEjecucionId() {
            return ejecucionId;
        }

        public void setEjecucionId(String ejecucionId) {
            this.ejecucionId = ejecucionId;
        }

        public String getCodigoResultado() {
            return codigoResultado;
        }

        public void setCodigoResultado(String codigoResultado) {
            this.codigoResultado = codigoResultado;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }
    }
    
    public static class ResultadoPaginado {
        private List<ResultadoCotejo> resultados;
        private Long totalElementos;
        private Integer totalPaginas;
        private Integer paginaActual;
        private Integer elementosPorPagina;

        public ResultadoPaginado() {
        }

        public List<ResultadoCotejo> getResultados() {
            return resultados;
        }

        public void setResultados(List<ResultadoCotejo> resultados) {
            this.resultados = resultados;
        }

        public Long getTotalElementos() {
            return totalElementos;
        }

        public void setTotalElementos(Long totalElementos) {
            this.totalElementos = totalElementos;
        }

        public Integer getTotalPaginas() {
            return totalPaginas;
        }

        public void setTotalPaginas(Integer totalPaginas) {
            this.totalPaginas = totalPaginas;
        }

        public Integer getPaginaActual() {
            return paginaActual;
        }

        public void setPaginaActual(Integer paginaActual) {
            this.paginaActual = paginaActual;
        }

        public Integer getElementosPorPagina() {
            return elementosPorPagina;
        }

        public void setElementosPorPagina(Integer elementosPorPagina) {
            this.elementosPorPagina = elementosPorPagina;
        }
    }
}
