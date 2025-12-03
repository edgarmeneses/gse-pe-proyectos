package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

public class DetalleErrorDto {
    private String detalleError;

    public DetalleErrorDto() {
    }

    public DetalleErrorDto(String detalleError) {
        this.detalleError = detalleError;
    }

    public String getDetalleError() {
        return detalleError;
    }

    public void setDetalleError(String detalleError) {
        this.detalleError = detalleError;
    }
}
