package pe.gob.reniec.dominioparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Value Object - Representa una inconsistencia detectada durante el análisis.
 * Inmutable y con lógica de negocio sobre severidad.
 */
public class DeteccionInconsistencia {
    
    private final TipoInconsistencia tipo;
    private final String descripcion;
    private final List<Ciudadano> ciudadanosAfectados;
    private final LocalDateTime fechaDeteccion;
    
    public DeteccionInconsistencia(TipoInconsistencia tipo, String descripcion,
                                   List<Ciudadano> ciudadanosAfectados,
                                   LocalDateTime fechaDeteccion) {
        this.tipo = Objects.requireNonNull(tipo, "El tipo no puede ser nulo");
        this.descripcion = Objects.requireNonNull(descripcion, "La descripción no puede ser nula");
        this.ciudadanosAfectados = ciudadanosAfectados != null ? 
            List.copyOf(ciudadanosAfectados) : List.of();
        this.fechaDeteccion = Objects.requireNonNull(fechaDeteccion, 
            "La fecha de detección no puede ser nula");
    }
    
    public boolean esCritica() {
        return tipo.esCritica();
    }
    
    public boolean requiereRevisionManual() {
        return tipo.requiereRevision();
    }
    
    public TipoInconsistencia getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public List<Ciudadano> getCiudadanosAfectados() { 
        return Collections.unmodifiableList(ciudadanosAfectados); 
    }
    public LocalDateTime getFechaDeteccion() { return fechaDeteccion; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeteccionInconsistencia that = (DeteccionInconsistencia) o;
        return tipo == that.tipo &&
               Objects.equals(descripcion, that.descripcion) &&
               Objects.equals(fechaDeteccion, that.fechaDeteccion);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(tipo, descripcion, fechaDeteccion);
    }
    
    @Override
    public String toString() {
        return tipo.name() + ": " + descripcion;
    }
}
