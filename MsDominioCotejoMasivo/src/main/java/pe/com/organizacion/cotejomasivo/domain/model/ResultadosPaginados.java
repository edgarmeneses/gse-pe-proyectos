package pe.com.organizacion.cotejomasivo.domain.model;

import java.util.List;

/**
 * Value Object: ResultadosPaginados
 * Representa una página de resultados de cotejo con información de paginación
 */
public class ResultadosPaginados {
    
    private String idEjecucion;
    private String estado;
    private List<ResultadoCotejo> resultados;
    private Long paginaActual;
    private Long tamanio;
    private Long totalResultados;
    private Long totalPaginas;
    
    public ResultadosPaginados() {
    }
    
    public ResultadosPaginados(String idEjecucion, String estado, List<ResultadoCotejo> resultados,
                              Long paginaActual, Long tamanio, Long totalResultados, Long totalPaginas) {
        this.idEjecucion = idEjecucion;
        this.estado = estado;
        this.resultados = resultados;
        this.paginaActual = paginaActual;
        this.tamanio = tamanio;
        this.totalResultados = totalResultados;
        this.totalPaginas = totalPaginas;
    }
    
    public String getIdEjecucion() {
        return idEjecucion;
    }
    
    public void setIdEjecucion(String idEjecucion) {
        this.idEjecucion = idEjecucion;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public List<ResultadoCotejo> getResultados() {
        return resultados;
    }
    
    public void setResultados(List<ResultadoCotejo> resultados) {
        this.resultados = resultados;
    }
    
    public Long getPaginaActual() {
        return paginaActual;
    }
    
    public void setPaginaActual(Long paginaActual) {
        this.paginaActual = paginaActual;
    }
    
    public Long getTamanio() {
        return tamanio;
    }
    
    public void setTamanio(Long tamanio) {
        this.tamanio = tamanio;
    }
    
    public Long getTotalResultados() {
        return totalResultados;
    }
    
    public void setTotalResultados(Long totalResultados) {
        this.totalResultados = totalResultados;
    }
    
    public Long getTotalPaginas() {
        return totalPaginas;
    }
    
    public void setTotalPaginas(Long totalPaginas) {
        this.totalPaginas = totalPaginas;
    }
}
