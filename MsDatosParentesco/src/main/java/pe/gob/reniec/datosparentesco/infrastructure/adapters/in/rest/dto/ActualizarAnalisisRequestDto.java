package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de request para actualizar un análisis de parentesco.
 */
public class ActualizarAnalisisRequestDto {
    
    private String estado;
    private CriteriosBusquedaDto criteriosBusqueda;
    private String observaciones;
    private String resultadoAnalisis;
    
    public ActualizarAnalisisRequestDto() {
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public CriteriosBusquedaDto getCriteriosBusqueda() {
        return criteriosBusqueda;
    }
    
    public void setCriteriosBusqueda(CriteriosBusquedaDto criteriosBusqueda) {
        this.criteriosBusqueda = criteriosBusqueda;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public String getResultadoAnalisis() {
        return resultadoAnalisis;
    }
    
    public void setResultadoAnalisis(String resultadoAnalisis) {
        this.resultadoAnalisis = resultadoAnalisis;
    }
}
