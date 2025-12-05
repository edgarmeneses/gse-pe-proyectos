package pe.gob.reniec.circunscripciones.domain.model;

public class Domicilio {

    private String direccion;
    private String ubigeo;
    private String departamento;
    private String provincia;
    private String distrito;

    public Domicilio() {
    }

    public Domicilio(String direccion, String ubigeo, String departamento, String provincia, String distrito) {
        this.direccion = direccion;
        this.ubigeo = ubigeo;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
}
