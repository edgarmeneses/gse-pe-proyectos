package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de datos para listar análisis de parentesco.
 */
public class ListarAnalisisDataDto {
    
    private List<AnalisisListaItemDto> analisis;
    private PaginacionDto paginacion;
    
    public ListarAnalisisDataDto() {
    }
    
    public ListarAnalisisDataDto(List<AnalisisListaItemDto> analisis, PaginacionDto paginacion) {
        this.analisis = analisis;
        this.paginacion = paginacion;
    }
    
    public List<AnalisisListaItemDto> getAnalisis() {
        return analisis;
    }
    
    public void setAnalisis(List<AnalisisListaItemDto> analisis) {
        this.analisis = analisis;
    }
    
    public PaginacionDto getPaginacion() {
        return paginacion;
    }
    
    public void setPaginacion(PaginacionDto paginacion) {
        this.paginacion = paginacion;
    }
}
