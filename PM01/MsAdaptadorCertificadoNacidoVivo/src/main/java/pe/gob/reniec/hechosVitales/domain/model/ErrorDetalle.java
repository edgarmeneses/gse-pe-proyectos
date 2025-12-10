package pe.gob.reniec.hechosVitales.domain.model;

/**
 * Value Object: ErrorDetalle
 * 
 * Representa el detalle específico de un error.
 */
public class ErrorDetalle {
    
    private String detalleError;
    
    public ErrorDetalle() {
    }
    
    public ErrorDetalle(String detalleError) {
        this.detalleError = detalleError;
    }
    
    public String getDetalleError() {
        return detalleError;
    }
    
    public void setDetalleError(String detalleError) {
        this.detalleError = detalleError;
    }
}
