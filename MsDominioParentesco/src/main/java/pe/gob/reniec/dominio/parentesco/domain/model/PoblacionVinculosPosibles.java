package pe.gob.reniec.dominio.parentesco.domain.model;

import java.util.List;

public class PoblacionVinculosPosibles {
    private Integer totalEncontrados;
    private List<VinculoConsanguineo> vinculosConsanguineos;
    private List<VinculoAfinidad> vinculosAfinidad;

    public PoblacionVinculosPosibles() {
    }

    public PoblacionVinculosPosibles(Integer totalEncontrados, List<VinculoConsanguineo> vinculosConsanguineos,
                                    List<VinculoAfinidad> vinculosAfinidad) {
        this.totalEncontrados = totalEncontrados;
        this.vinculosConsanguineos = vinculosConsanguineos;
        this.vinculosAfinidad = vinculosAfinidad;
    }

    public Integer getTotalEncontrados() {
        return totalEncontrados;
    }

    public void setTotalEncontrados(Integer totalEncontrados) {
        this.totalEncontrados = totalEncontrados;
    }

    public List<VinculoConsanguineo> getVinculosConsanguineos() {
        return vinculosConsanguineos;
    }

    public void setVinculosConsanguineos(List<VinculoConsanguineo> vinculosConsanguineos) {
        this.vinculosConsanguineos = vinculosConsanguineos;
    }

    public List<VinculoAfinidad> getVinculosAfinidad() {
        return vinculosAfinidad;
    }

    public void setVinculosAfinidad(List<VinculoAfinidad> vinculosAfinidad) {
        this.vinculosAfinidad = vinculosAfinidad;
    }
}
