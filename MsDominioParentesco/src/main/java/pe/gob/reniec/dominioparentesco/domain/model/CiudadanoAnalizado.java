package pe.gob.reniec.dominioparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entity - Representa un ciudadano analizado con sus datos del APD.
 */
public class CiudadanoAnalizado {
    
    private final String idCiudadano;
    private final String nombre;
    private final LocalDateTime fechaNacimiento;
    private final DatosAPD datosAPD;
    
    public CiudadanoAnalizado(String idCiudadano, String nombre, 
                             LocalDateTime fechaNacimiento, DatosAPD datosAPD) {
        this.idCiudadano = Objects.requireNonNull(idCiudadano, "El ID del ciudadano no puede ser nulo");
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.fechaNacimiento = Objects.requireNonNull(fechaNacimiento, "La fecha de nacimiento no puede ser nula");
        this.datosAPD = datosAPD;
    }
    
    public String getIdCiudadano() {
        return idCiudadano;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public DatosAPD getDatosAPD() {
        return datosAPD;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CiudadanoAnalizado that = (CiudadanoAnalizado) o;
        return Objects.equals(idCiudadano, that.idCiudadano);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idCiudadano);
    }
    
    @Override
    public String toString() {
        return "CiudadanoAnalizado{" +
                "idCiudadano='" + idCiudadano + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", datosAPD=" + datosAPD +
                '}';
    }
}
