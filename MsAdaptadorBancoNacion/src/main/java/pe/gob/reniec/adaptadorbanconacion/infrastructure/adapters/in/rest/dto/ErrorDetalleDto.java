package pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto;

public class ErrorDetalleDto {

    private String detalleError;

    public ErrorDetalleDto() {
    }

    public ErrorDetalleDto(String detalleError) {
        this.detalleError = detalleError;
    }

    public String getDetalleError() {
        return detalleError;
    }

    public void setDetalleError(String detalleError) {
        this.detalleError = detalleError;
    }
}
