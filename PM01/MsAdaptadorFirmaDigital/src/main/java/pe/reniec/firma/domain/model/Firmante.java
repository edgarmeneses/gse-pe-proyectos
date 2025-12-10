package pe.reniec.firma.domain.model;

public class Firmante {
    private String usuarioId;
    private String dni;
    private String nombreCompleto;
    private String cargo;
    private String certificadoId;
    private String email;

    public Firmante() {}

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCertificadoId() {
        return certificadoId;
    }

    public void setCertificadoId(String certificadoId) {
        this.certificadoId = certificadoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
