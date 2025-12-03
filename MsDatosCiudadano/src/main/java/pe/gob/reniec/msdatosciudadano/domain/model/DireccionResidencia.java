package pe.gob.reniec.msdatosciudadano.domain.model;

public class DireccionResidencia {
    private String pais;
    private String departamento;
    private String provincia;
    private String distrito;
    private String centroPoblado;
    private String barrio;
    private String direccion;
    private String codigoPostal;

    public DireccionResidencia() {
    }

    public DireccionResidencia(String pais, String departamento, String provincia, String distrito,
                              String centroPoblado, String barrio, String direccion, String codigoPostal) {
        this.pais = pais;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.centroPoblado = centroPoblado;
        this.barrio = barrio;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    public String getCentroPoblado() {
        return centroPoblado;
    }

    public void setCentroPoblado(String centroPoblado) {
        this.centroPoblado = centroPoblado;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
