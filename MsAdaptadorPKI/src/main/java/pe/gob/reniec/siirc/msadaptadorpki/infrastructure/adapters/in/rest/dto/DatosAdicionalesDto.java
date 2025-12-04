package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto;

public class DatosAdicionalesDto {
    private String emailCiudadano;
    private String telefonoCiudadano;
    private String direccionCiudadano;
    private String usuarioRegistro;
    private String observaciones;

    public DatosAdicionalesDto() {
    }

    public String getEmailCiudadano() {
        return emailCiudadano;
    }

    public void setEmailCiudadano(String emailCiudadano) {
        this.emailCiudadano = emailCiudadano;
    }

    public String getTelefonoCiudadano() {
        return telefonoCiudadano;
    }

    public void setTelefonoCiudadano(String telefonoCiudadano) {
        this.telefonoCiudadano = telefonoCiudadano;
    }

    public String getDireccionCiudadano() {
        return direccionCiudadano;
    }

    public void setDireccionCiudadano(String direccionCiudadano) {
        this.direccionCiudadano = direccionCiudadano;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
