package pe.gob.reniec.datosparentesco.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Value Object inmutable que representa los criterios de búsqueda para el análisis de parentesco.
 * Encapsula la lógica de validación y normalización de criterios.
 */
public final class CriteriosBusqueda {
    
    private static final int LONGITUD_MINIMA_VARIACION = 2;
    private static final int LONGITUD_MAXIMA_VARIACION = 100;
    
    private final RangoAnios rangoAniosPadres;
    private final RangoAnios rangoAniosHijos;
    private final List<String> variacionesNombre;
    
    private CriteriosBusqueda(RangoAnios rangoAniosPadres, RangoAnios rangoAniosHijos, List<String> variacionesNombre) {
        this.rangoAniosPadres = rangoAniosPadres;
        this.rangoAniosHijos = rangoAniosHijos;
        this.variacionesNombre = variacionesNombre != null 
            ? Collections.unmodifiableList(new ArrayList<>(variacionesNombre))
            : Collections.emptyList();
    }
    
    /**
     * Factory method que crea criterios de búsqueda validados.
     */
    public static CriteriosBusqueda of(RangoAnios rangoAniosPadres, RangoAnios rangoAniosHijos, List<String> variacionesNombre) {
        validarVariacionesNombre(variacionesNombre);
        return new CriteriosBusqueda(rangoAniosPadres, rangoAniosHijos, normalizarVariaciones(variacionesNombre));
    }
    
    private static void validarVariacionesNombre(List<String> variaciones) {
        if (variaciones == null) {
            return;
        }
        
        for (String variacion : variaciones) {
            if (variacion == null || variacion.trim().isEmpty()) {
                throw new IllegalArgumentException("Las variaciones de nombre no pueden ser nulas o vacías");
            }
            
            String variacionLimpia = variacion.trim();
            if (variacionLimpia.length() < LONGITUD_MINIMA_VARIACION) {
                throw new IllegalArgumentException(
                    String.format("Las variaciones deben tener al menos %d caracteres", LONGITUD_MINIMA_VARIACION)
                );
            }
            
            if (variacionLimpia.length() > LONGITUD_MAXIMA_VARIACION) {
                throw new IllegalArgumentException(
                    String.format("Las variaciones no pueden exceder %d caracteres", LONGITUD_MAXIMA_VARIACION)
                );
            }
        }
    }
    
    /**
     * Normaliza las variaciones: trim, uppercase, y elimina duplicados.
     */
    private static List<String> normalizarVariaciones(List<String> variaciones) {
        if (variaciones == null) {
            return Collections.emptyList();
        }
        
        return variaciones.stream()
            .filter(Objects::nonNull)
            .map(String::trim)
            .map(String::toUpperCase)
            .distinct()
            .collect(Collectors.toList());
    }
    
    /**
     * Verifica si tiene criterios de búsqueda para padres.
     */
    public boolean tieneCriteriosPadres() {
        return rangoAniosPadres != null;
    }
    
    /**
     * Verifica si tiene criterios de búsqueda para hijos.
     */
    public boolean tieneCriteriosHijos() {
        return rangoAniosHijos != null;
    }
    
    /**
     * Verifica si tiene variaciones de nombre definidas.
     */
    public boolean tieneVariacionesNombre() {
        return variacionesNombre != null && !variacionesNombre.isEmpty();
    }
    
    /**
     * Calcula la complejidad de los criterios de búsqueda.
     * Útil para determinar el nivel de complejidad del análisis.
     */
    public int calcularComplejidad() {
        int complejidad = 0;
        if (tieneCriteriosPadres()) complejidad += 1;
        if (tieneCriteriosHijos()) complejidad += 1;
        if (tieneVariacionesNombre()) complejidad += variacionesNombre.size();
        return complejidad;
    }
    
    public RangoAnios getRangoAniosPadres() {
        return rangoAniosPadres;
    }
    
    public RangoAnios getRangoAniosHijos() {
        return rangoAniosHijos;
    }
    
    public List<String> getVariacionesNombre() {
        return variacionesNombre;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriteriosBusqueda that = (CriteriosBusqueda) o;
        return Objects.equals(rangoAniosPadres, that.rangoAniosPadres) &&
               Objects.equals(rangoAniosHijos, that.rangoAniosHijos) &&
               Objects.equals(variacionesNombre, that.variacionesNombre);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(rangoAniosPadres, rangoAniosHijos, variacionesNombre);
    }
}
