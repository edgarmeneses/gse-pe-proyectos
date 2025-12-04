package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para información de paginación.
 */
public class PaginacionDto {
    
    private Integer totalRegistros;
    private Integer totalPaginas;
    private Integer paginaActual;
    private Integer tamanioPagina;
    private Boolean tieneAnterior;
    private Boolean tieneSiguiente;
    
    public PaginacionDto() {
    }
    
    public PaginacionDto(Integer totalRegistros, Integer totalPaginas, Integer paginaActual, 
                        Integer tamanioPagina, Boolean tieneAnterior, Boolean tieneSiguiente) {
        this.totalRegistros = totalRegistros;
        this.totalPaginas = totalPaginas;
        this.paginaActual = paginaActual;
        this.tamanioPagina = tamanioPagina;
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
    
    public Integer getTamanioPagina() {
        return tamanioPagina;
    }
    
    public void setTamanioPagina(Integer tamanioPagina) {
        this.tamanioPagina = tamanioPagina;
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
