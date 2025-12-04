package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response;

/**
 * Detalle de un error específico en la respuesta HTTP.
 * Estructura técnica para reportar errores de validación o procesamiento.
 * NO es un concepto del dominio de negocio.
 */
public class DetalleError {
    private String campo;
    private String mensaje;
    private String codigo;

    public DetalleError() {
    }

    public DetalleError(String campo, String mensaje, String codigo) {
        this.campo = campo;
        this.mensaje = mensaje;
        this.codigo = codigo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
