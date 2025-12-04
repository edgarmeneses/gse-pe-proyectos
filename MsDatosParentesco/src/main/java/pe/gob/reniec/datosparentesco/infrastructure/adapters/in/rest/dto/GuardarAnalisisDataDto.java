package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de response para guardar un análisis de parentesco (datos).
 */
public class GuardarAnalisisDataDto {
    
    private String idAnalisis;
    private String fechaRegistro;
    private String estado;
    
    public GuardarAnalisisDataDto() {
    }
    
    public GuardarAnalisisDataDto(String idAnalisis, String fechaRegistro, String estado) {
        this.idAnalisis = idAnalisis;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }
    
    public String getIdAnalisis() {
        return idAnalisis;
    }
    
    public void setIdAnalisis(String idAnalisis) {
        this.idAnalisis = idAnalisis;
    }
    
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
