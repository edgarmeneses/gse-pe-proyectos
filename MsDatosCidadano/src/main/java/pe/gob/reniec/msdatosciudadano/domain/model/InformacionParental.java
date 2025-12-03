package pe.gob.reniec.msdatosciudadano.domain.model;

public class InformacionParental {
    private String primerNombrePaterno;
    private String segundoNombrePaterno;
    private String primerApellidoPaterno;
    private String segundoApellidoPaterno;
    private String primerNombreMaterno;
    private String segundoNombreMaterno;
    private String primerApellidoMaterno;
    private String segundoApellidoMaterno;
    private String tipoDocumentoPaterno;
    private String numeroDocumentoPaterno;
    private String tipoDocumentoMaterno;
    private String numeroDocumentoMaterno;

    public InformacionParental() {
    }

    public InformacionParental(String primerNombrePaterno, String segundoNombrePaterno, 
                              String primerApellidoPaterno, String segundoApellidoPaterno,
                              String primerNombreMaterno, String segundoNombreMaterno, 
                              String primerApellidoMaterno, String segundoApellidoMaterno,
                              String tipoDocumentoPaterno, String numeroDocumentoPaterno, 
                              String tipoDocumentoMaterno, String numeroDocumentoMaterno) {
        this.primerNombrePaterno = primerNombrePaterno;
        this.segundoNombrePaterno = segundoNombrePaterno;
        this.primerApellidoPaterno = primerApellidoPaterno;
        this.segundoApellidoPaterno = segundoApellidoPaterno;
        this.primerNombreMaterno = primerNombreMaterno;
        this.segundoNombreMaterno = segundoNombreMaterno;
        this.primerApellidoMaterno = primerApellidoMaterno;
        this.segundoApellidoMaterno = segundoApellidoMaterno;
        this.tipoDocumentoPaterno = tipoDocumentoPaterno;
        this.numeroDocumentoPaterno = numeroDocumentoPaterno;
        this.tipoDocumentoMaterno = tipoDocumentoMaterno;
        this.numeroDocumentoMaterno = numeroDocumentoMaterno;
    }

    public String getPrimerNombrePaterno() {
        return primerNombrePaterno;
    }

    public void setPrimerNombrePaterno(String primerNombrePaterno) {
        this.primerNombrePaterno = primerNombrePaterno;
    }

    public String getSegundoNombrePaterno() {
        return segundoNombrePaterno;
    }

    public void setSegundoNombrePaterno(String segundoNombrePaterno) {
        this.segundoNombrePaterno = segundoNombrePaterno;
    }

    public String getPrimerApellidoPaterno() {
        return primerApellidoPaterno;
    }

    public void setPrimerApellidoPaterno(String primerApellidoPaterno) {
        this.primerApellidoPaterno = primerApellidoPaterno;
    }

    public String getSegundoApellidoPaterno() {
        return segundoApellidoPaterno;
    }

    public void setSegundoApellidoPaterno(String segundoApellidoPaterno) {
        this.segundoApellidoPaterno = segundoApellidoPaterno;
    }

    public String getPrimerNombreMaterno() {
        return primerNombreMaterno;
    }

    public void setPrimerNombreMaterno(String primerNombreMaterno) {
        this.primerNombreMaterno = primerNombreMaterno;
    }

    public String getSegundoNombreMaterno() {
        return segundoNombreMaterno;
    }

    public void setSegundoNombreMaterno(String segundoNombreMaterno) {
        this.segundoNombreMaterno = segundoNombreMaterno;
    }

    public String getPrimerApellidoMaterno() {
        return primerApellidoMaterno;
    }

    public void setPrimerApellidoMaterno(String primerApellidoMaterno) {
        this.primerApellidoMaterno = primerApellidoMaterno;
    }

    public String getSegundoApellidoMaterno() {
        return segundoApellidoMaterno;
    }

    public void setSegundoApellidoMaterno(String segundoApellidoMaterno) {
        this.segundoApellidoMaterno = segundoApellidoMaterno;
    }

    public String getTipoDocumentoPaterno() {
        return tipoDocumentoPaterno;
    }

    public void setTipoDocumentoPaterno(String tipoDocumentoPaterno) {
        this.tipoDocumentoPaterno = tipoDocumentoPaterno;
    }

    public String getNumeroDocumentoPaterno() {
        return numeroDocumentoPaterno;
    }

    public void setNumeroDocumentoPaterno(String numeroDocumentoPaterno) {
        this.numeroDocumentoPaterno = numeroDocumentoPaterno;
    }

    public String getTipoDocumentoMaterno() {
        return tipoDocumentoMaterno;
    }

    public void setTipoDocumentoMaterno(String tipoDocumentoMaterno) {
        this.tipoDocumentoMaterno = tipoDocumentoMaterno;
    }

    public String getNumeroDocumentoMaterno() {
        return numeroDocumentoMaterno;
    }

    public void setNumeroDocumentoMaterno(String numeroDocumentoMaterno) {
        this.numeroDocumentoMaterno = numeroDocumentoMaterno;
    }
}
