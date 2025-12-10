package pe.gob.reniec.padronelectoral.infrastructure.dto;

public class ErrorDetail {
    private String detalleError;

    public ErrorDetail() {
    }

    public ErrorDetail(String detalleError) {
        this.detalleError = detalleError;
    }

    public String getDetalleError() {
        return detalleError;
    }

    public void setDetalleError(String detalleError) {
        this.detalleError = detalleError;
    }
}
