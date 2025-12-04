package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para información de relación inversa.
 */
public class RelacionInversaDto {
    
    private Long idRelacion;
    private String codigoTipo;
    
    public RelacionInversaDto() {
    }
    
    public RelacionInversaDto(Long idRelacion, String codigoTipo) {
        this.idRelacion = idRelacion;
        this.codigoTipo = codigoTipo;
    }
    
    public Long getIdRelacion() {
        return idRelacion;
    }
    
    public void setIdRelacion(Long idRelacion) {
        this.idRelacion = idRelacion;
    }
    
    public String getCodigoTipo() {
        return codigoTipo;
    }
    
    public void setCodigoTipo(String codigoTipo) {
        this.codigoTipo = codigoTipo;
    }
}
