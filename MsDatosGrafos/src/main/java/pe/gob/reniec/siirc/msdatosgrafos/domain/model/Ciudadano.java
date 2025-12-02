package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

import java.time.LocalDate;

/**
 * Entity que representa a un ciudadano
 */
public class Ciudadano {
    private final String idCiudadano;
    private final String nombre;
    private final LocalDate fechaNacimiento;

    public Ciudadano(String idCiudadano, String nombre, LocalDate fechaNacimiento) {
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
