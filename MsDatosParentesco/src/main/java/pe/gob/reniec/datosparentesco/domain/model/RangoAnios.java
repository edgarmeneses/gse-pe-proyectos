package pe.gob.reniec.datosparentesco.domain.model;

import java.time.Year;
import java.util.Objects;

/**
 * Value Object inmutable que representa un rango de años para criterios de búsqueda.
 * Garantiza la invariante: anioInicio <= anioFin
 */
public final class RangoAnios {
    
    private final Integer anioInicio;
    private final Integer anioFin;
    
    private RangoAnios(Integer anioInicio, Integer anioFin) {
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
    }
    
    /**
     * Factory method que valida y crea un rango de años.
     */
    public static RangoAnios of(Integer anioInicio, Integer anioFin) {
        validar(anioInicio, anioFin);
        return new RangoAnios(anioInicio, anioFin);
    }
    
    private static void validar(Integer anioInicio, Integer anioFin) {
        if (anioInicio == null || anioFin == null) {
            throw new IllegalArgumentException("Los años del rango no pueden ser nulos");
        }
        
        if (anioInicio > anioFin) {
            throw new IllegalArgumentException(
                String.format("El año inicial (%d) no puede ser mayor al año final (%d)", anioInicio, anioFin)
            );
        }
        
        int anioActual = Year.now().getValue();
        if (anioFin > anioActual) {
            throw new IllegalArgumentException(
                String.format("El año final (%d) no puede ser mayor al año actual (%d)", anioFin, anioActual)
            );
        }
        
        if (anioInicio < 1900) {
            throw new IllegalArgumentException("El año inicial no puede ser anterior a 1900");
        }
    }
    
    /**
     * Calcula la cantidad de años en el rango (inclusivo).
     */
    public int cantidadAnios() {
        return anioFin - anioInicio + 1;
    }
    
    /**
     * Verifica si un año está dentro del rango.
     */
    public boolean contieneAnio(int anio) {
        return anio >= anioInicio && anio <= anioFin;
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
        return String.format("RangoAnios[%d-%d]", anioInicio, anioFin);
    }
}
