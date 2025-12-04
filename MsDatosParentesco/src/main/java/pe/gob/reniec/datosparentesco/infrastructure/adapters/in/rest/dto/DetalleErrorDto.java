package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para detalle de error.
 */
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
