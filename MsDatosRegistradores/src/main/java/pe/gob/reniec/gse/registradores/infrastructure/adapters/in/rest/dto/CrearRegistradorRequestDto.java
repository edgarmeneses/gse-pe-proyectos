package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

/**
 * DTO Request: Crear Registrador
 */
public class CrearRegistradorRequestDto {
    private String idRegistrador;
    private String numeroDni;
    private String primerApellido;
    private String segundoApellido;
    private String prenombres;
    private String codigoLocal;
    private String tipoRegistrador;
    private String observaciones;

    public CrearRegistradorRequestDto() {
    }

    public CrearRegistradorRequestDto(String idRegistrador, String numeroDni, String primerApellido, 
                                     String segundoApellido, String prenombres, String codigoLocal, 
                                     String tipoRegistrador, String observaciones) {
        this.idRegistrador = idRegistrador;
        this.numeroDni = numeroDni;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.prenombres = prenombres;
        this.codigoLocal = codigoLocal;
        this.tipoRegistrador = tipoRegistrador;
        this.observaciones = observaciones;
    }

    public String getIdRegistrador() {
        return idRegistrador;
    }

    public void setIdRegistrador(String idRegistrador) {
        this.idRegistrador = idRegistrador;
    }

    public String getNumeroDni() {
        return numeroDni;
    }

    public void setNumeroDni(String numeroDni) {
        this.numeroDni = numeroDni;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrenombres() {
        return prenombres;
    }

    public void setPrenombres(String prenombres) {
        this.prenombres = prenombres;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getTipoRegistrador() {
        return tipoRegistrador;
    }

    public void setTipoRegistrador(String tipoRegistrador) {
        this.tipoRegistrador = tipoRegistrador;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
