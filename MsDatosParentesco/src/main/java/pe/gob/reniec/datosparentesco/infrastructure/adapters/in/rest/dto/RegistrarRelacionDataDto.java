package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de datos para registrar una relación de parentesco.
 */
public class RegistrarRelacionDataDto {
    
    private Long idRelacion;
    private RelacionInversaDto relacionInversa;
    private String fechaRegistro;
    
    public RegistrarRelacionDataDto() {
    }
    
    public RegistrarRelacionDataDto(Long idRelacion, RelacionInversaDto relacionInversa, String fechaRegistro) {
        this.idRelacion = idRelacion;
        this.relacionInversa = relacionInversa;
        this.fechaRegistro = fechaRegistro;
    }
    
    public Long getIdRelacion() {
        return idRelacion;
    }
    
    public void setIdRelacion(Long idRelacion) {
        this.idRelacion = idRelacion;
    }
    
    public RelacionInversaDto getRelacionInversa() {
        return relacionInversa;
    }
    
    public void setRelacionInversa(RelacionInversaDto relacionInversa) {
        this.relacionInversa = relacionInversa;
    }
    
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
