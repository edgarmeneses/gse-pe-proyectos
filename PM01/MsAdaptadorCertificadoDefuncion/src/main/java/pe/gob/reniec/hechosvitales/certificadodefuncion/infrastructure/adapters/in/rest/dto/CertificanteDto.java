package pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Información del Profesional Certificante
 */
public class CertificanteDto {

    private String deProfDocIdentidad;
    private String deProfNombres;
    private String deProfApellidoPaterno;
    private String deProfApellidoMaterno;
    private String coColegioProf;
    private String deColegioProf;
    private String nuColegioProf;

    public CertificanteDto() {
    }

    public String getDeProfDocIdentidad() {
        return deProfDocIdentidad;
    }

    public void setDeProfDocIdentidad(String deProfDocIdentidad) {
        this.deProfDocIdentidad = deProfDocIdentidad;
    }

    public String getDeProfNombres() {
        return deProfNombres;
    }

    public void setDeProfNombres(String deProfNombres) {
        this.deProfNombres = deProfNombres;
    }

    public String getDeProfApellidoPaterno() {
        return deProfApellidoPaterno;
    }

    public void setDeProfApellidoPaterno(String deProfApellidoPaterno) {
        this.deProfApellidoPaterno = deProfApellidoPaterno;
    }

    public String getDeProfApellidoMaterno() {
        return deProfApellidoMaterno;
    }

    public void setDeProfApellidoMaterno(String deProfApellidoMaterno) {
        this.deProfApellidoMaterno = deProfApellidoMaterno;
    }

    public String getCoColegioProf() {
        return coColegioProf;
    }

    public void setCoColegioProf(String coColegioProf) {
        this.coColegioProf = coColegioProf;
    }

    public String getDeColegioProf() {
        return deColegioProf;
    }

    public void setDeColegioProf(String deColegioProf) {
        this.deColegioProf = deColegioProf;
    }

    public String getNuColegioProf() {
        return nuColegioProf;
    }

    public void setNuColegioProf(String nuColegioProf) {
        this.nuColegioProf = nuColegioProf;
    }
}
