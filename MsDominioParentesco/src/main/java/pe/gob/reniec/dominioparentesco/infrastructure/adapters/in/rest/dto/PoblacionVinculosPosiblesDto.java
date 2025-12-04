package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO para la población de vínculos posibles.
 */
public class PoblacionVinculosPosiblesDto {
    private Integer totalEncontrados;
    private List<VinculoConsanguineoDto> vinculosConsanguineos;
    private List<VinculoAfinidadDto> vinculosAfinidad;

    public PoblacionVinculosPosiblesDto() {}

    public Integer getTotalEncontrados() { return totalEncontrados; }
    public void setTotalEncontrados(Integer totalEncontrados) { this.totalEncontrados = totalEncontrados; }

    public List<VinculoConsanguineoDto> getVinculosConsanguineos() { return vinculosConsanguineos; }
    public void setVinculosConsanguineos(List<VinculoConsanguineoDto> vinculosConsanguineos) { this.vinculosConsanguineos = vinculosConsanguineos; }

    public List<VinculoAfinidadDto> getVinculosAfinidad() { return vinculosAfinidad; }
    public void setVinculosAfinidad(List<VinculoAfinidadDto> vinculosAfinidad) { this.vinculosAfinidad = vinculosAfinidad; }
}
