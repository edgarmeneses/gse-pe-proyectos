package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO que representa el detalle de un error.
 */
public class ErrorDetailDto {

    private String detalleError;

    public ErrorDetailDto() {
    }

    public ErrorDetailDto(String detalleError) {
        this.detalleError = detalleError;
    }

    public String getDetalleError() {
        return detalleError;
    }

    public void setDetalleError(String detalleError) {
        this.detalleError = detalleError;
    }
}
