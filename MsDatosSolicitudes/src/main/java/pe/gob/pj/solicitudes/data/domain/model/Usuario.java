package pe.gob.pj.solicitudes.data.domain.model;

public class Usuario {
    
    private String usuarioId;
    private String nombreCompleto;
    private String rol;
    private String email;

    public Usuario() {
    }

    public Usuario(String usuarioId, String nombreCompleto, String rol, String email) {
        this.usuarioId = usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
        this.email = email;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
