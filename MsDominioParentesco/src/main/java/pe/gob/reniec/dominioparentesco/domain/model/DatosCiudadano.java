package pe.gob.reniec.dominioparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Value Object - Representa los datos básicos de un ciudadano.
 */
public class DatosCiudadano {
    
    private final String nombre;
    private final LocalDateTime fechaNacimiento;
    
    public DatosCiudadano(String nombre, LocalDateTime fechaNacimiento) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.fechaNacimiento = Objects.requireNonNull(fechaNacimiento, "La fecha de nacimiento no puede ser nula");
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosCiudadano that = (DatosCiudadano) o;
        return Objects.equals(nombre, that.nombre) && 
               Objects.equals(fechaNacimiento, that.fechaNacimiento);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaNacimiento);
    }
    
    @Override
    public String toString() {
        return "DatosCiudadano{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
