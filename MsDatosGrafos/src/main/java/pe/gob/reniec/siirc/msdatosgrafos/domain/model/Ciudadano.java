package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

import java.time.LocalDateTime;

/**
 * Entity que representa a un ciudadano en el sistema.
 */
public class Ciudadano {
    private final String idCiudadano;
    private final String nombre;
    private final LocalDateTime fechaNacimiento;

    public Ciudadano(String idCiudadano, String nombre, LocalDateTime fechaNacimiento) {
        if (idCiudadano == null || idCiudadano.isEmpty()) {
            throw new IllegalArgumentException("El ID del ciudadano es obligatorio");
        }
        this.idCiudadano = idCiudadano;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudadano ciudadano = (Ciudadano) o;
        return idCiudadano.equals(ciudadano.idCiudadano);
    }

    @Override
    public int hashCode() {
        return idCiudadano.hashCode();
    }
}
