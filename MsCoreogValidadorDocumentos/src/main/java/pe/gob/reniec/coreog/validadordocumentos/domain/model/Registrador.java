package pe.gob.reniec.coreog.validadordocumentos.domain.model;

/**
 * Entidad de dominio: Registrador
 * Representa los datos de un registrador civil
 */
public class Registrador {
    
    private String numeroDniRegistrador;
    private String idUsuario;
    private String primerApellido;
    private String segundoApellido;
    private String prenombres;
    private String codigoLocal;
    
    public Registrador() {
    }
    
    public Registrador(String numeroDniRegistrador, String idUsuario, String primerApellido, 
                       String segundoApellido, String prenombres, String codigoLocal) {
        this.numeroDniRegistrador = numeroDniRegistrador;
        this.idUsuario = idUsuario;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.prenombres = prenombres;
        this.codigoLocal = codigoLocal;
    }
    
    public String getNumeroDniRegistrador() {
        return numeroDniRegistrador;
    }
    
    public void setNumeroDniRegistrador(String numeroDniRegistrador) {
        this.numeroDniRegistrador = numeroDniRegistrador;
    }
    
    public String getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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
}
