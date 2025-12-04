package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de datos para actualizar un análisis de parentesco.
 */
public class ActualizarAnalisisDataDto {
    
    private String idAnalisis;
    private String estado;
    private String fechaModificacion;
    
    public ActualizarAnalisisDataDto() {
    }
    
    public ActualizarAnalisisDataDto(String idAnalisis, String estado, String fechaModificacion) {
        this.idAnalisis = idAnalisis;
        this.estado = estado;
        this.fechaModificacion = fechaModificacion;
    }
    
    public String getIdAnalisis() {
        return idAnalisis;
    }
    
    public void setIdAnalisis(String idAnalisis) {
        this.idAnalisis = idAnalisis;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getFechaModificacion() {
        return fechaModificacion;
    }
    
    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
