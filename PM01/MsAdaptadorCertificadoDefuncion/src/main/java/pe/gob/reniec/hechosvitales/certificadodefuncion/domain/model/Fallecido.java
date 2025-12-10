package pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model;

/**
 * Value Object: Información del Fallecido
 */
public class Fallecido {

    private String coTitularTipoDocIdentidad;
    private String deTitularDocIdentidad;
    private String deTitularPrimerApellido;
    private String deTitularSegundoApellido;
    private String deTitularPrenombres;
    private String feTitularNacimiento;
    private String deTitularSexo;
    private String coTitularEstadoCivil;
    private String deTitularEstadoCivil;
    private String coTitularGradoInstruccion;
    private String deTitularGradoInstruccion;
    private String coTitularOcupacion;
    private String deTitularOcupacion;

    public Fallecido() {
    }

    public Fallecido(String coTitularTipoDocIdentidad, String deTitularDocIdentidad, 
                     String deTitularPrimerApellido, String deTitularSegundoApellido, 
                     String deTitularPrenombres, String feTitularNacimiento, 
                     String deTitularSexo, String coTitularEstadoCivil, 
                     String deTitularEstadoCivil, String coTitularGradoInstruccion, 
                     String deTitularGradoInstruccion, String coTitularOcupacion, 
                     String deTitularOcupacion) {
        this.coTitularTipoDocIdentidad = coTitularTipoDocIdentidad;
        this.deTitularDocIdentidad = deTitularDocIdentidad;
        this.deTitularPrimerApellido = deTitularPrimerApellido;
        this.deTitularSegundoApellido = deTitularSegundoApellido;
        this.deTitularPrenombres = deTitularPrenombres;
        this.feTitularNacimiento = feTitularNacimiento;
        this.deTitularSexo = deTitularSexo;
        this.coTitularEstadoCivil = coTitularEstadoCivil;
        this.deTitularEstadoCivil = deTitularEstadoCivil;
        this.coTitularGradoInstruccion = coTitularGradoInstruccion;
        this.deTitularGradoInstruccion = deTitularGradoInstruccion;
        this.coTitularOcupacion = coTitularOcupacion;
        this.deTitularOcupacion = deTitularOcupacion;
    }

    public String getCoTitularTipoDocIdentidad() {
        return coTitularTipoDocIdentidad;
    }

    public void setCoTitularTipoDocIdentidad(String coTitularTipoDocIdentidad) {
        this.coTitularTipoDocIdentidad = coTitularTipoDocIdentidad;
    }

    public String getDeTitularDocIdentidad() {
        return deTitularDocIdentidad;
    }

    public void setDeTitularDocIdentidad(String deTitularDocIdentidad) {
        this.deTitularDocIdentidad = deTitularDocIdentidad;
    }

    public String getDeTitularPrimerApellido() {
        return deTitularPrimerApellido;
    }

    public void setDeTitularPrimerApellido(String deTitularPrimerApellido) {
        this.deTitularPrimerApellido = deTitularPrimerApellido;
    }

    public String getDeTitularSegundoApellido() {
        return deTitularSegundoApellido;
    }

    public void setDeTitularSegundoApellido(String deTitularSegundoApellido) {
        this.deTitularSegundoApellido = deTitularSegundoApellido;
    }

    public String getDeTitularPrenombres() {
        return deTitularPrenombres;
    }

    public void setDeTitularPrenombres(String deTitularPrenombres) {
        this.deTitularPrenombres = deTitularPrenombres;
    }

    public String getFeTitularNacimiento() {
        return feTitularNacimiento;
    }

    public void setFeTitularNacimiento(String feTitularNacimiento) {
        this.feTitularNacimiento = feTitularNacimiento;
    }

    public String getDeTitularSexo() {
        return deTitularSexo;
    }

    public void setDeTitularSexo(String deTitularSexo) {
        this.deTitularSexo = deTitularSexo;
    }

    public String getCoTitularEstadoCivil() {
        return coTitularEstadoCivil;
    }

    public void setCoTitularEstadoCivil(String coTitularEstadoCivil) {
        this.coTitularEstadoCivil = coTitularEstadoCivil;
    }

    public String getDeTitularEstadoCivil() {
        return deTitularEstadoCivil;
    }

    public void setDeTitularEstadoCivil(String deTitularEstadoCivil) {
        this.deTitularEstadoCivil = deTitularEstadoCivil;
    }

    public String getCoTitularGradoInstruccion() {
        return coTitularGradoInstruccion;
    }

    public void setCoTitularGradoInstruccion(String coTitularGradoInstruccion) {
        this.coTitularGradoInstruccion = coTitularGradoInstruccion;
    }

    public String getDeTitularGradoInstruccion() {
        return deTitularGradoInstruccion;
    }

    public void setDeTitularGradoInstruccion(String deTitularGradoInstruccion) {
        this.deTitularGradoInstruccion = deTitularGradoInstruccion;
    }

    public String getCoTitularOcupacion() {
        return coTitularOcupacion;
    }

    public void setCoTitularOcupacion(String coTitularOcupacion) {
        this.coTitularOcupacion = coTitularOcupacion;
    }

    public String getDeTitularOcupacion() {
        return deTitularOcupacion;
    }

    public void setDeTitularOcupacion(String deTitularOcupacion) {
        this.deTitularOcupacion = deTitularOcupacion;
    }
}
