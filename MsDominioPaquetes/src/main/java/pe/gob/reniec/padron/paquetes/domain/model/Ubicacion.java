package pe.gob.reniec.padron.paquetes.domain.model;

public class Ubicacion {
    private String codigoDepartamento;
    private String nombreDepartamento;
    private String codigoProvincia;
    private String nombreProvincia;
    private String codigoDistrito;
    private String nombreDistrito;
    private String ubigeo;

    public Ubicacion() {
    }

    public Ubicacion(String codigoDepartamento, String nombreDepartamento, String codigoProvincia,
                     String nombreProvincia, String codigoDistrito, String nombreDistrito, String ubigeo) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.codigoProvincia = codigoProvincia;
        this.nombreProvincia = nombreProvincia;
        this.codigoDistrito = codigoDistrito;
        this.nombreDistrito = nombreDistrito;
        this.ubigeo = ubigeo;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(String codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }
}
