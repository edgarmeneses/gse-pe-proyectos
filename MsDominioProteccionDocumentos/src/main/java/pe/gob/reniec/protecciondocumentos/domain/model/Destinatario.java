package pe.gob.reniec.protecciondocumentos.domain.model;

public class Destinatario {
    private String email;
    private String telefono;
    private String nombreCompleto;

    public Destinatario() {
    }

    public Destinatario(String email, String telefono, String nombreCompleto) {
        this.email = email;
        this.telefono = telefono;
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
