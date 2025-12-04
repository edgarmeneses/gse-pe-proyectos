package pe.gob.reniec.dominioparentesco.domain.model;

import java.util.List;
import java.util.Objects;

/**
 * Value Object - Representa una inconsistencia detectada durante el análisis.
 */
public class Inconsistencia {
    
    private final String tipo;
    private final String descripcion;
    private final List<String> ciudadanosInvolucrados;
    private final String severidad;
    private final String accionRecomendada;
    
    public Inconsistencia(String tipo, String descripcion, 
                         List<String> ciudadanosInvolucrados,
                         String severidad, String accionRecomendada) {
        this.tipo = Objects.requireNonNull(tipo, "El tipo no puede ser nulo");
        this.descripcion = Objects.requireNonNull(descripcion, "La descripción no puede ser nula");
        this.ciudadanosInvolucrados = ciudadanosInvolucrados != null ? 
            List.copyOf(ciudadanosInvolucrados) : List.of();
        this.severidad = Objects.requireNonNull(severidad, "La severidad no puede ser nula");
        this.accionRecomendada = accionRecomendada;
    }
    
    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public List<String> getCiudadanosInvolucrados() { return ciudadanosInvolucrados; }
    public String getSeveridad() { return severidad; }
    public String getAccionRecomendada() { return accionRecomendada; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inconsistencia that = (Inconsistencia) o;
        return Objects.equals(tipo, that.tipo) &&
               Objects.equals(descripcion, that.descripcion) &&
               Objects.equals(severidad, that.severidad);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(tipo, descripcion, severidad);
    }
    
    @Override
    public String toString() {
        return "Inconsistencia{" +
                "tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", severidad='" + severidad + '\'' +
                '}';
    }
}
