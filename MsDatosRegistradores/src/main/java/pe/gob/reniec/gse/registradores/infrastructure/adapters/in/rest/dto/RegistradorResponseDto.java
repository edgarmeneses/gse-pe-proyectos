package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

/**
 * DTO Response: Registrador Creado
 */
public class RegistradorResponseDto {
    private String idRegistrador;
    private String numeroDni;
    private String nombreCompleto;
    private String codigoLocal;
    private String descripcionLocal;
    private String codigoEstadoRegistrador;
    private String descripcionEstado;
    private String fechaRegistro;
    private String usuarioRegistro;
    private LinksDto links;

    public RegistradorResponseDto() {
    }

    public RegistradorResponseDto(String idRegistrador, String numeroDni, String nombreCompleto, 
                                 String codigoLocal, String descripcionLocal, String codigoEstadoRegistrador, 
                                 String descripcionEstado, String fechaRegistro, String usuarioRegistro, 
                                 LinksDto links) {
        this.idRegistrador = idRegistrador;
        this.numeroDni = numeroDni;
        this.nombreCompleto = nombreCompleto;
        this.codigoLocal = codigoLocal;
        this.descripcionLocal = descripcionLocal;
        this.codigoEstadoRegistrador = codigoEstadoRegistrador;
        this.descripcionEstado = descripcionEstado;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
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

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public LinksDto getLinks() {
        return links;
    }

    public void setLinks(LinksDto links) {
        this.links = links;
    }
}
