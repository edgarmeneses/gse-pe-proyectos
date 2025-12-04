package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para el rango de años en los criterios de búsqueda.
 */
public class RangoAniosDto {
    private Integer anioInicio;
    private Integer anioFin;

    public RangoAniosDto() {}

    public RangoAniosDto(Integer anioInicio, Integer anioFin) {
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
    }

    public Integer getAnioInicio() { return anioInicio; }
    public void setAnioInicio(Integer anioInicio) { this.anioInicio = anioInicio; }

    public Integer getAnioFin() { return anioFin; }
    public void setAnioFin(Integer anioFin) { this.anioFin = anioFin; }
}
