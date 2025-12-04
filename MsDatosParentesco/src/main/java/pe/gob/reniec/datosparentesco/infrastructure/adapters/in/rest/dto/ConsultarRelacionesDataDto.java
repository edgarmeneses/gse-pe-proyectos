package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de datos para consultar relaciones de parentesco.
 */
public class ConsultarRelacionesDataDto {
    
    private CiudadanoDto ciudadano;
    private List<RelacionItemDto> relaciones;
    private Integer totalRelaciones;
    
    public ConsultarRelacionesDataDto() {
    }
    
    public ConsultarRelacionesDataDto(CiudadanoDto ciudadano, List<RelacionItemDto> relaciones, 
                                     Integer totalRelaciones) {
        this.ciudadano = ciudadano;
        this.relaciones = relaciones;
        this.totalRelaciones = totalRelaciones;
    }
    
    public CiudadanoDto getCiudadano() {
        return ciudadano;
    }
    
    public void setCiudadano(CiudadanoDto ciudadano) {
        this.ciudadano = ciudadano;
    }
    
    public List<RelacionItemDto> getRelaciones() {
        return relaciones;
    }
    
    public void setRelaciones(List<RelacionItemDto> relaciones) {
        this.relaciones = relaciones;
    }
    
    public Integer getTotalRelaciones() {
        return totalRelaciones;
    }
    
    public void setTotalRelaciones(Integer totalRelaciones) {
        this.totalRelaciones = totalRelaciones;
    }
}
