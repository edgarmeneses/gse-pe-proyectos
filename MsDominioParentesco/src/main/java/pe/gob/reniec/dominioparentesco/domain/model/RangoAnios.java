package pe.gob.reniec.dominioparentesco.domain.model;

import java.util.Objects;

/**
 * Value Object - Representa un rango de años para criterios de búsqueda.
 */
public class RangoAnios {
    
    private final Integer anioInicio;
    private final Integer anioFin;
    
    public RangoAnios(Integer anioInicio, Integer anioFin) {
        this.anioInicio = Objects.requireNonNull(anioInicio, "El año de inicio no puede ser nulo");
        this.anioFin = Objects.requireNonNull(anioFin, "El año fin no puede ser nulo");
        
        if (anioInicio > anioFin) {
            throw new IllegalArgumentException("El año de inicio no puede ser mayor al año fin");
        }
    }
    
    public Integer getAnioInicio() {
        return anioInicio;
    }
    
    public Integer getAnioFin() {
        return anioFin;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RangoAnios that = (RangoAnios) o;
        return Objects.equals(anioInicio, that.anioInicio) && 
               Objects.equals(anioFin, that.anioFin);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(anioInicio, anioFin);
    }
    
    @Override
    public String toString() {
        return "RangoAnios{" +
                "anioInicio=" + anioInicio +
                ", anioFin=" + anioFin +
                '}';
    }
}
