package pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto;

public class MetadataDto {

    private String dni;
    private String nombreCompleto;
    private String codigoOficina;
    private String usuarioRegistrador;

    public MetadataDto() {
    }

    public MetadataDto(String dni, String nombreCompleto, String codigoOficina, String usuarioRegistrador) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.codigoOficina = codigoOficina;
        this.usuarioRegistrador = usuarioRegistrador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public String getUsuarioRegistrador() {
        return usuarioRegistrador;
    }

    public void setUsuarioRegistrador(String usuarioRegistrador) {
        this.usuarioRegistrador = usuarioRegistrador;
    }
}
