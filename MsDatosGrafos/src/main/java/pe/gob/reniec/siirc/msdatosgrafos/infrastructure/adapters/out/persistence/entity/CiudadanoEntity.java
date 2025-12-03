package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;

public class CiudadanoEntity {
    private String idCiudadano;
    private String nombre;
    private LocalDateTime fechaNacimiento;

    public CiudadanoEntity() {
    }

    public CiudadanoEntity(String idCiudadano, String nombre, LocalDateTime fechaNacimiento) {
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

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
