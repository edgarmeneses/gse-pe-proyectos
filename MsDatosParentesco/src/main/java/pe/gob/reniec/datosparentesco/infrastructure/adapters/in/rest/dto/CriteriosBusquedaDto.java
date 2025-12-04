package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO para representar criterios de búsqueda en las operaciones REST.
 */
public class CriteriosBusquedaDto {
    
    private RangoAniosDto rangoAniosPadres;
    private RangoAniosDto rangoAniosHijos;
    private List<String> variacionesNombre;
    
    public CriteriosBusquedaDto() {
    }
    
    public CriteriosBusquedaDto(RangoAniosDto rangoAniosPadres, RangoAniosDto rangoAniosHijos, 
                               List<String> variacionesNombre) {
        this.rangoAniosPadres = rangoAniosPadres;
        this.rangoAniosHijos = rangoAniosHijos;
        this.variacionesNombre = variacionesNombre;
    }
    
    public RangoAniosDto getRangoAniosPadres() {
        return rangoAniosPadres;
    }
    
    public void setRangoAniosPadres(RangoAniosDto rangoAniosPadres) {
        this.rangoAniosPadres = rangoAniosPadres;
    }
    
    public RangoAniosDto getRangoAniosHijos() {
        return rangoAniosHijos;
    }
    
    public void setRangoAniosHijos(RangoAniosDto rangoAniosHijos) {
        this.rangoAniosHijos = rangoAniosHijos;
    }
    
    public List<String> getVariacionesNombre() {
        return variacionesNombre;
    }
    
    public void setVariacionesNombre(List<String> variacionesNombre) {
        this.variacionesNombre = variacionesNombre;
    }
}
