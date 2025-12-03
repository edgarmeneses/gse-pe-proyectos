package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

/**
 * DTO: Registrador en Listado
 */
public class RegistradorListadoDto {
    private String idRegistrador;
    private String numeroDni;
    private String nombreCompleto;
    private String primerApellido;
    private String segundoApellido;
    private String prenombres;
    private String codigoLocal;
    private String descripcionLocal;
    private String codigoEstadoRegistrador;
    private String descripcionEstado;
    private Boolean tieneFirmaRegistrada;
    private Boolean tieneSellosRegistrado;
    private String fechaCreacion;
    private LinksDto links;

    public RegistradorListadoDto() {
    }

    public RegistradorListadoDto(String idRegistrador, String numeroDni, String nombreCompleto, 
                                String primerApellido, String segundoApellido, String prenombres, 
                                String codigoLocal, String descripcionLocal, String codigoEstadoRegistrador, 
                                String descripcionEstado, Boolean tieneFirmaRegistrada, 
                                Boolean tieneSellosRegistrado, String fechaCreacion, LinksDto links) {
        this.idRegistrador = idRegistrador;
        this.numeroDni = numeroDni;
        this.nombreCompleto = nombreCompleto;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.prenombres = prenombres;
        this.codigoLocal = codigoLocal;
        this.descripcionLocal = descripcionLocal;
        this.codigoEstadoRegistrador = codigoEstadoRegistrador;
        this.descripcionEstado = descripcionEstado;
        this.tieneFirmaRegistrada = tieneFirmaRegistrada;
        this.tieneSellosRegistrado = tieneSellosRegistrado;
        this.fechaCreacion = fechaCreacion;
        this.links = links;
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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

    public String getDescripcionLocal() {
        return descripcionLocal;
    }

    public void setDescripcionLocal(String descripcionLocal) {
        this.descripcionLocal = descripcionLocal;
    }

    public String getCodigoEstadoRegistrador() {
        return codigoEstadoRegistrador;
    }

    public void setCodigoEstadoRegistrador(String codigoEstadoRegistrador) {
        this.codigoEstadoRegistrador = codigoEstadoRegistrador;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public Boolean getTieneFirmaRegistrada() {
        return tieneFirmaRegistrada;
    }

    public void setTieneFirmaRegistrada(Boolean tieneFirmaRegistrada) {
        this.tieneFirmaRegistrada = tieneFirmaRegistrada;
    }

    public Boolean getTieneSellosRegistrado() {
        return tieneSellosRegistrado;
    }

    public void setTieneSellosRegistrado(Boolean tieneSellosRegistrado) {
        this.tieneSellosRegistrado = tieneSellosRegistrado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LinksDto getLinks() {
        return links;
    }

    public void setLinks(LinksDto links) {
        this.links = links;
    }
}
