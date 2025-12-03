package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class VinculosParentescoDataDto {
    private CiudadanoDto ciudadanoConsultado;
    private List<VinculoDto> vinculos;
    private ResumenVinculosDto resumen;
    private PaginacionDto paginacion;

    public VinculosParentescoDataDto() {
    }

    public VinculosParentescoDataDto(CiudadanoDto ciudadanoConsultado, List<VinculoDto> vinculos,
                                     ResumenVinculosDto resumen, PaginacionDto paginacion) {
        this.ciudadanoConsultado = ciudadanoConsultado;
        this.vinculos = vinculos;
        this.resumen = resumen;
        this.paginacion = paginacion;
    }

    public CiudadanoDto getCiudadanoConsultado() {
        return ciudadanoConsultado;
    }

    public void setCiudadanoConsultado(CiudadanoDto ciudadanoConsultado) {
        this.ciudadanoConsultado = ciudadanoConsultado;
    }

    public List<VinculoDto> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<VinculoDto> vinculos) {
        this.vinculos = vinculos;
    }

    public ResumenVinculosDto getResumen() {
        return resumen;
    }

    public void setResumen(ResumenVinculosDto resumen) {
        this.resumen = resumen;
    }

    public PaginacionDto getPaginacion() {
        return paginacion;
    }

    public void setPaginacion(PaginacionDto paginacion) {
        this.paginacion = paginacion;
    }
}
