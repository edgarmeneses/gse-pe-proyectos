package pe.gob.reniec.gse.datosparentesco.domain.model;

public class RangoAnios {
    private Integer anioInicio;
    private Integer anioFin;

    public RangoAnios() {
    }

    public RangoAnios(Integer anioInicio, Integer anioFin) {
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
    }

    public Integer getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(Integer anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Integer getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(Integer anioFin) {
        this.anioFin = anioFin;
    }
}
