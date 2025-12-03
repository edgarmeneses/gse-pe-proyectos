package pe.gob.pj.solicitudes.data.domain.model;

public class Direccion {
    
    private String departamento;
    private String provincia;
    private String distrito;
    private String direccionCompleta;

    public Direccion() {
    }

    public Direccion(String departamento, String provincia, String distrito, String direccionCompleta) {
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.direccionCompleta = direccionCompleta;
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

    public String getDireccionCompleta() {
        return direccionCompleta;
    }

    public void setDireccionCompleta(String direccionCompleta) {
        this.direccionCompleta = direccionCompleta;
    }
}
