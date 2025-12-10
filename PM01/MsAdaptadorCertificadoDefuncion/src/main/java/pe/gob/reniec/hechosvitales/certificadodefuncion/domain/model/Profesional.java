package pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model;

/**
 * Value Object: Información básica del Profesional
 */
public class Profesional {

    private String deProfDocIdentidad;

    public Profesional() {
    }

    public Profesional(String deProfDocIdentidad) {
        this.deProfDocIdentidad = deProfDocIdentidad;
    }

    public String getDeProfDocIdentidad() {
        return deProfDocIdentidad;
    }

    public void setDeProfDocIdentidad(String deProfDocIdentidad) {
        this.deProfDocIdentidad = deProfDocIdentidad;
    }
}
