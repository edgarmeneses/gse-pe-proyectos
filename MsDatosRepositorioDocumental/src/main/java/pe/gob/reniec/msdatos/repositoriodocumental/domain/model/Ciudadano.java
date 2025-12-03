package pe.gob.reniec.msdatos.repositoriodocumental.domain.model;

/**
 * Value Object: Ciudadano
 * Representa la información básica de un ciudadano.
 */
public class Ciudadano {

    private String dni;
    private String nombreCompleto;

    public Ciudadano() {
    }

    public Ciudadano(String dni, String nombreCompleto) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
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
}
