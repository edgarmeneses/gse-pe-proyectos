package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para representar una relación en la consulta.
 */
public class RelacionItemDto {
    
    private Long idRelacion;
    private String tipoParentesco;
    private String descripcionParentesco;
    private Integer gradoParentesco;
    private CiudadanoDto ciudadanoRelacionado;
    private String actaSustento;
    private Boolean vigente;
    
    public RelacionItemDto() {
    }
    
    public Long getIdRelacion() {
        return idRelacion;
    }
    
    public void setIdRelacion(Long idRelacion) {
        this.idRelacion = idRelacion;
    }
    
    public String getTipoParentesco() {
        return tipoParentesco;
    }
    
    public void setTipoParentesco(String tipoParentesco) {
        this.tipoParentesco = tipoParentesco;
    }
    
    public String getDescripcionParentesco() {
        return descripcionParentesco;
    }
    
    public void setDescripcionParentesco(String descripcionParentesco) {
        this.descripcionParentesco = descripcionParentesco;
    }
    
    public Integer getGradoParentesco() {
        return gradoParentesco;
    }
    
    public void setGradoParentesco(Integer gradoParentesco) {
        this.gradoParentesco = gradoParentesco;
    }
    
    public CiudadanoDto getCiudadanoRelacionado() {
        return ciudadanoRelacionado;
    }
    
    public void setCiudadanoRelacionado(CiudadanoDto ciudadanoRelacionado) {
        this.ciudadanoRelacionado = ciudadanoRelacionado;
    }
    
    public String getActaSustento() {
        return actaSustento;
    }
    
    public void setActaSustento(String actaSustento) {
        this.actaSustento = actaSustento;
    }
    
    public Boolean getVigente() {
        return vigente;
    }
    
    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }
}
