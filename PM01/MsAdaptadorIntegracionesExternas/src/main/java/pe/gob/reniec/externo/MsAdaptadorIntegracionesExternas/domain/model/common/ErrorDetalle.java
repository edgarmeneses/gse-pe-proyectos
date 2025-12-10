package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.common;

public class ErrorDetalle {
    private String detalleError;

    public ErrorDetalle() {}

    public ErrorDetalle(String detalleError) {
        this.detalleError = detalleError;
    }

    public String getDetalleError() { return detalleError; }
    public void setDetalleError(String detalleError) { this.detalleError = detalleError; }
}
