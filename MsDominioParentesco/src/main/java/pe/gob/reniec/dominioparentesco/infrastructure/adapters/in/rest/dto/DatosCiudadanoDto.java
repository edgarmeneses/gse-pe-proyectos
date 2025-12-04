package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

/**
 * DTO para los datos del ciudadano en la solicitud de análisis.
 */
public class DatosCiudadanoDto {
    private String nombre;
    private LocalDateTime fechaNacimiento;

    public DatosCiudadanoDto() {}

    public DatosCiudadanoDto(String nombre, LocalDateTime fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDateTime getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDateTime fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}
