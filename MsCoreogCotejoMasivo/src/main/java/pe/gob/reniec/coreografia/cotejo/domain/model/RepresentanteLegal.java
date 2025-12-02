package pe.gob.reniec.coreografia.cotejo.domain.model;

public class RepresentanteLegal {
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public RepresentanteLegal() {
    }

    public RepresentanteLegal(String dni, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
}
