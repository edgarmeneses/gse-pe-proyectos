package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para el cónyuge intermedio en vínculos de afinidad.
 */
public class ConyugeIntermedioDto {
    private String idCiudadano;
    private String nombre;

    public ConyugeIntermedioDto() {}

    public String getIdCiudadano() { return idCiudadano; }
    public void setIdCiudadano(String idCiudadano) { this.idCiudadano = idCiudadano; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
