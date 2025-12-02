package pe.gob.reniec.msdatosciudadano.domain.model;

public class Contacto {
    private String telefonoFijo;
    private String telefonoMovil;
    private String correoElectronico;
    private String correoAlternativo;

    public Contacto() {
    }

    public Contacto(String telefonoFijo, String telefonoMovil, String correoElectronico, String correoAlternativo) {
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
        this.correoElectronico = correoElectronico;
        this.correoAlternativo = correoAlternativo;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoAlternativo() {
        return correoAlternativo;
    }

    public void setCorreoAlternativo(String correoAlternativo) {
        this.correoAlternativo = correoAlternativo;
    }
}
