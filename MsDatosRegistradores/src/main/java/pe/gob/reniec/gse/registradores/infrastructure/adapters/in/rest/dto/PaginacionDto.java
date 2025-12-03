package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Paginación
 */
public class PaginacionDto {
    private Long totalRegistros;
    private Long totalPaginas;
    private Long paginaActual;
    private Long registrosPorPagina;
    private Boolean tieneAnterior;
    private Boolean tieneSiguiente;

    public PaginacionDto() {
    }

    public PaginacionDto(Long totalRegistros, Long totalPaginas, Long paginaActual, 
                        Long registrosPorPagina, Boolean tieneAnterior, Boolean tieneSiguiente) {
        this.totalRegistros = totalRegistros;
        this.totalPaginas = totalPaginas;
        this.paginaActual = paginaActual;
        this.registrosPorPagina = registrosPorPagina;
        this.tieneAnterior = tieneAnterior;
        this.tieneSiguiente = tieneSiguiente;
    }

    public Long getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(Long totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    public Long getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(Long totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public Long getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(Long paginaActual) {
        this.paginaActual = paginaActual;
    }

    public Long getRegistrosPorPagina() {
        return registrosPorPagina;
    }

    public void setRegistrosPorPagina(Long registrosPorPagina) {
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
