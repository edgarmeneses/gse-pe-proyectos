package pe.gob.reniec.datosparentesco.infrastructure.adapters.out.persistence.entity;

/**
 * Entidad de persistencia para Ciudadano.
 * POJO sin anotaciones JPA/frameworks.
 */
public class CiudadanoEntity {
    
    private String idCiudadano;
    private String nombre;
    
    public CiudadanoEntity() {
    }
    
    public CiudadanoEntity(String idCiudadano, String nombre) {
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
