package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para representar un rango de años en las operaciones REST.
 */
public class RangoAniosDto {
    
    private Integer anioInicio;
    private Integer anioFin;
    
    public RangoAniosDto() {
    }
    
    public RangoAniosDto(Integer anioInicio, Integer anioFin) {
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
    }
    
    public Integer getAnioInicio() {
        return anioInicio;
    }
    
    public void setAnioInicio(Integer anioInicio) {
        this.anioInicio = anioInicio;
    }
    
    public Integer getAnioFin() {
        return anioFin;
    }
    
    public void setAnioFin(Integer anioFin) {
        this.anioFin = anioFin;
    }
}
