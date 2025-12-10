package pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Información del Declarante
 */
public class DeclaranteDto {

    private String coDeclaranteTipoDocIdentidad;
    private String deDeclaranteDocIdentidad;
    private String deDeclaranteNombres;
    private String deDeclaranteApellidoPaterno;
    private String deDeclaranteApellidoMaterno;
    private String coParentesco;
    private String deParentesco;

    public DeclaranteDto() {
    }

    public String getCoDeclaranteTipoDocIdentidad() {
        return coDeclaranteTipoDocIdentidad;
    }

    public void setCoDeclaranteTipoDocIdentidad(String coDeclaranteTipoDocIdentidad) {
        this.coDeclaranteTipoDocIdentidad = coDeclaranteTipoDocIdentidad;
    }

    public String getDeDeclaranteDocIdentidad() {
        return deDeclaranteDocIdentidad;
    }

    public void setDeDeclaranteDocIdentidad(String deDeclaranteDocIdentidad) {
        this.deDeclaranteDocIdentidad = deDeclaranteDocIdentidad;
    }

    public String getDeDeclaranteNombres() {
        return deDeclaranteNombres;
    }

    public void setDeDeclaranteNombres(String deDeclaranteNombres) {
        this.deDeclaranteNombres = deDeclaranteNombres;
    }

    public String getDeDeclaranteApellidoPaterno() {
        return deDeclaranteApellidoPaterno;
    }

    public void setDeDeclaranteApellidoPaterno(String deDeclaranteApellidoPaterno) {
        this.deDeclaranteApellidoPaterno = deDeclaranteApellidoPaterno;
    }

    public String getDeDeclaranteApellidoMaterno() {
        return deDeclaranteApellidoMaterno;
    }

    public void setDeDeclaranteApellidoMaterno(String deDeclaranteApellidoMaterno) {
        this.deDeclaranteApellidoMaterno = deDeclaranteApellidoMaterno;
    }

    public String getCoParentesco() {
        return coParentesco;
    }

    public void setCoParentesco(String coParentesco) {
        this.coParentesco = coParentesco;
    }

    public String getDeParentesco() {
        return deParentesco;
    }

    public void setDeParentesco(String deParentesco) {
        this.deParentesco = deParentesco;
    }
}
