package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

/**
 * DTO para los datos del ciudadano analizado.
 */
public class CiudadanoAnalizadoDto {
    private String idCiudadano;
    private String nombre;
    private LocalDateTime fechaNacimiento;
    private DatosAPDDto datosAPD;

    public CiudadanoAnalizadoDto() {}

    public String getIdCiudadano() { return idCiudadano; }
    public void setIdCiudadano(String idCiudadano) { this.idCiudadano = idCiudadano; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDateTime getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDateTime fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public DatosAPDDto getDatosAPD() { return datosAPD; }
    public void setDatosAPD(DatosAPDDto datosAPD) { this.datosAPD = datosAPD; }
}
