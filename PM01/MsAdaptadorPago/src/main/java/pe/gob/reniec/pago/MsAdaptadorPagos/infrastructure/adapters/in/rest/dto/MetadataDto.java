package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto;

public class MetadataDto {
    private String dni;
    private String nombreCompleto;
    private String codigoOficina;
    private String usuarioRegistrador;
    private String canalPago;
    private String metodoPago;
    private String email;
    private String telefono;

    public MetadataDto() {}

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCodigoOficina() { return codigoOficina; }
    public void setCodigoOficina(String codigoOficina) { this.codigoOficina = codigoOficina; }

    public String getUsuarioRegistrador() { return usuarioRegistrador; }
    public void setUsuarioRegistrador(String usuarioRegistrador) { this.usuarioRegistrador = usuarioRegistrador; }

    public String getCanalPago() { return canalPago; }
    public void setCanalPago(String canalPago) { this.canalPago = canalPago; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
