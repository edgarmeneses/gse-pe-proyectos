package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

public class ResumenVinculosDto {
    private Integer totalVinculos;
    private Integer vinculosConsanguineos;
    private Integer vinculosPorAfinidad;
    private Integer vinculosVigentes;
    private Integer vinculosNoVigentes;

    public ResumenVinculosDto() {
    }

    public ResumenVinculosDto(Integer totalVinculos, Integer vinculosConsanguineos,
                              Integer vinculosPorAfinidad, Integer vinculosVigentes,
                              Integer vinculosNoVigentes) {
        this.totalVinculos = totalVinculos;
        this.vinculosConsanguineos = vinculosConsanguineos;
        this.vinculosPorAfinidad = vinculosPorAfinidad;
        this.vinculosVigentes = vinculosVigentes;
        this.vinculosNoVigentes = vinculosNoVigentes;
    }

    public Integer getTotalVinculos() {
        return totalVinculos;
    }

    public void setTotalVinculos(Integer totalVinculos) {
        this.totalVinculos = totalVinculos;
    }

    public Integer getVinculosConsanguineos() {
        return vinculosConsanguineos;
    }

    public void setVinculosConsanguineos(Integer vinculosConsanguineos) {
        this.vinculosConsanguineos = vinculosConsanguineos;
    }

    public Integer getVinculosPorAfinidad() {
        return vinculosPorAfinidad;
    }

    public void setVinculosPorAfinidad(Integer vinculosPorAfinidad) {
        this.vinculosPorAfinidad = vinculosPorAfinidad;
    }

    public Integer getVinculosVigentes() {
        return vinculosVigentes;
    }

    public void setVinculosVigentes(Integer vinculosVigentes) {
        this.vinculosVigentes = vinculosVigentes;
    }

    public Integer getVinculosNoVigentes() {
        return vinculosNoVigentes;
    }

    public void setVinculosNoVigentes(Integer vinculosNoVigentes) {
        this.vinculosNoVigentes = vinculosNoVigentes;
    }
}
