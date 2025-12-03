package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

public class PaginacionDto {
    private Integer paginaActual;
    private Integer registrosPorPagina;
    private Integer totalRegistros;
    private Integer totalPaginas;
    private Boolean tieneAnterior;
    private Boolean tieneSiguiente;

    public PaginacionDto() {
    }

    public PaginacionDto(Integer paginaActual, Integer registrosPorPagina, Integer totalRegistros,
                         Integer totalPaginas, Boolean tieneAnterior, Boolean tieneSiguiente) {
        this.paginaActual = paginaActual;
        this.registrosPorPagina = registrosPorPagina;
        this.totalRegistros = totalRegistros;
        this.totalPaginas = totalPaginas;
        this.tieneAnterior = tieneAnterior;
        this.tieneSiguiente = tieneSiguiente;
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
