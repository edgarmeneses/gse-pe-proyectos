package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.response;

/**
 * Información de paginación para consultas.
 * Esta clase pertenece a la capa de aplicación.
 */
public class InformacionPaginacion {
    private Integer totalRegistros;
    private Integer totalPaginas;
    private Integer paginaActual;
    private Integer registrosPorPagina;
    private Boolean tieneAnterior;
    private Boolean tieneSiguiente;

    public InformacionPaginacion() {
    }

    public InformacionPaginacion(Integer totalRegistros, Integer totalPaginas, Integer paginaActual,
                                 Integer registrosPorPagina, Boolean tieneAnterior, Boolean tieneSiguiente) {
        this.totalRegistros = totalRegistros;
        this.totalPaginas = totalPaginas;
        this.paginaActual = paginaActual;
        this.registrosPorPagina = registrosPorPagina;
        this.tieneAnterior = tieneAnterior;
        this.tieneSiguiente = tieneSiguiente;
    }

    public Integer getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(Integer totalRegistros) {
        this.totalRegistros = totalRegistros;
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

    public Integer getRegistrosPorPagina() {
        return registrosPorPagina;
    }

    public void setRegistrosPorPagina(Integer registrosPorPagina) {
        this.registrosPorPagina = registrosPorPagina;
    }

    public Boolean getTieneAnterior() {
        return tieneAnterior;
    }

    public void setTieneAnterior(Boolean tieneAnterior) {
        this.tieneAnterior = tieneAnterior;
    }

    public Boolean getTieneSiguiente() {
        return tieneSiguiente;
    }

    public void setTieneSiguiente(Boolean tieneSiguiente) {
        this.tieneSiguiente = tieneSiguiente;
    }
}
