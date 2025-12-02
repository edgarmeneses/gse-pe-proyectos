package pe.gob.reniec.dominio.parentesco.domain.model;

public class ConyugeIntermedio {
    private String idCiudadano;
    private String nombreCompleto;

    public ConyugeIntermedio() {
    }

    public ConyugeIntermedio(String idCiudadano, String nombreCompleto) {
        this.idCiudadano = idCiudadano;
        this.nombreCompleto = nombreCompleto;
    }

    public String getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(String idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
