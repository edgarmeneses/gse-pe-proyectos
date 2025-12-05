package pe.gob.reniec.analizadoractas.domain.model;

/**
 * Value Object: Representa el usuario que solicita el análisis
 */
public class UsuarioSolicitante {

    private String dni;
    private String nombres;
    private String apellidos;
    private String rol;
    private String nombreCompleto;

    public UsuarioSolicitante() {
    }

    public UsuarioSolicitante(String dni, String nombres, String apellidos, String rol) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rol = rol;
        this.nombreCompleto = nombres + " " + apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
