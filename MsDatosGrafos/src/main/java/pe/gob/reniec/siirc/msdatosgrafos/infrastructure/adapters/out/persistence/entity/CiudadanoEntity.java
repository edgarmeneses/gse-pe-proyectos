package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;

/**
 * Entity para persistencia de Ciudadano
 * POJO sin anotaciones de framework
 */
public class CiudadanoEntity {
    private String idCiudadano;
    private String nombre;
    private LocalDate fechaNacimiento;

    public CiudadanoEntity() {
    }

    public CiudadanoEntity(String idCiudadano, String nombre, LocalDate fechaNacimiento) {
        this.idCiudadano = idCiudadano;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(String idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
