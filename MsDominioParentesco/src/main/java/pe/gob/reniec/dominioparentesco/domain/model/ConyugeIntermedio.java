package pe.gob.reniec.dominioparentesco.domain.model;

import java.util.Objects;

/**
 * Value Object - Representa información de un cónyuge intermedio en vínculos de afinidad.
 */
public class ConyugeIntermedio {
    
    private final String idCiudadano;
    private final String nombre;
    
    public ConyugeIntermedio(String idCiudadano, String nombre) {
        this.idCiudadano = Objects.requireNonNull(idCiudadano, "El ID del ciudadano no puede ser nulo");
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
    }
    
    public String getIdCiudadano() {
        return idCiudadano;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConyugeIntermedio that = (ConyugeIntermedio) o;
        return Objects.equals(idCiudadano, that.idCiudadano);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idCiudadano);
    }
    
    @Override
    public String toString() {
        return "ConyugeIntermedio{" +
                "idCiudadano='" + idCiudadano + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
