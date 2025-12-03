package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

/**
 * Value Object - Representa un paso siguiente en el flujo del proceso
 */
public class SiguientePaso {
    
    private String paso;
    private String descripcion;
    
    public SiguientePaso() {
    }
    
    public SiguientePaso(String paso, String descripcion) {
        this.paso = paso;
        this.descripcion = descripcion;
    }
    
    public String getPaso() {
        return paso;
    }
    
    public void setPaso(String paso) {
        this.paso = paso;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
