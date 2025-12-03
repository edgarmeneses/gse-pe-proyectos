package pe.gob.reniec.agendamiento.msdatos.application.query;

/**
 * ResultadoPaginado - Query Result (Application Layer)
 * Representa metadata de paginación para resultados de consultas.
 * No es parte del dominio, es un concepto de infraestructura HTTP.
 */
public class ResultadoPaginado {
    private Integer totalElementos;
    private Integer totalPaginas;
    private Integer paginaActual;
    private Integer elementosPorPagina;
    private Boolean haySiguiente;
    private Boolean hayAnterior;

    public ResultadoPaginado() {
    }

    public ResultadoPaginado(Integer totalElementos, Integer totalPaginas, Integer paginaActual,
                             Integer elementosPorPagina, Boolean haySiguiente, Boolean hayAnterior) {
        this.totalElementos = totalElementos;
        this.totalPaginas = totalPaginas;
        this.paginaActual = paginaActual;
        this.elementosPorPagina = elementosPorPagina;
        this.haySiguiente = haySiguiente;
        this.hayAnterior = hayAnterior;
    }

    public Integer getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(Integer totalElementos) {
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

    public Boolean isHaySiguiente() {
        return haySiguiente;
    }

    public void setHaySiguiente(Boolean haySiguiente) {
        this.haySiguiente = haySiguiente;
    }

    public Boolean isHayAnterior() {
        return hayAnterior;
    }

    public void setHayAnterior(Boolean hayAnterior) {
        this.hayAnterior = hayAnterior;
    }
}
