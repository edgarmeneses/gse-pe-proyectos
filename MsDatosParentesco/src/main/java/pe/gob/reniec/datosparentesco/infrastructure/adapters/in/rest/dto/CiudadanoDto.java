package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para información de ciudadano.
 */
public class CiudadanoDto {
    
    private String idCiudadano;
    private String nombre;
    
    public CiudadanoDto() {
    }
    
    public CiudadanoDto(String idCiudadano, String nombre) {
        this.idCiudadano = idCiudadano;
        this.nombre = nombre;
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
}
