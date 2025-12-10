package pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Información básica del Profesional
 */
public class ProfesionalDto {

    private String deProfDocIdentidad;

    public ProfesionalDto() {
    }

    public ProfesionalDto(String deProfDocIdentidad) {
        this.deProfDocIdentidad = deProfDocIdentidad;
    }

    public String getDeProfDocIdentidad() {
        return deProfDocIdentidad;
    }

    public void setDeProfDocIdentidad(String deProfDocIdentidad) {
        this.deProfDocIdentidad = deProfDocIdentidad;
    }
}
