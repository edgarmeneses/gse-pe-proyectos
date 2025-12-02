package pe.gob.reniec.gse.datosparentesco.domain.model;

public class Ciudadano {
    private String idCiudadano;
    private String nombre;

    public Ciudadano() {
    }

    public Ciudadano(String idCiudadano, String nombre) {
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
