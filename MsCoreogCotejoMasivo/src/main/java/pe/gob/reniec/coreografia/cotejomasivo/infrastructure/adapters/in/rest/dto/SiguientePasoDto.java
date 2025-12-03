package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO - Siguiente Paso
 */
public class SiguientePasoDto {
    
    private String paso;
    private String descripcion;
    
    public SiguientePasoDto() {
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
