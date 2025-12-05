package pe.gob.reniec.circunscripciones.domain.model;

public class EstadisticasListado {

    private Integer totalCircunscripciones;
    private Integer totalCiudadanos;
    private Integer totalEquipos;
    private Double promedioporEquipo;
    private Boolean rutasOptimizadas;

    public EstadisticasListado() {
    }

    public EstadisticasListado(Integer totalCircunscripciones, Integer totalCiudadanos,
                              Integer totalEquipos, Double promedioporEquipo, Boolean rutasOptimizadas) {
        this.totalCircunscripciones = totalCircunscripciones;
        this.totalCiudadanos = totalCiudadanos;
        this.totalEquipos = totalEquipos;
        this.promedioporEquipo = promedioporEquipo;
        this.rutasOptimizadas = rutasOptimizadas;
    }

    public Integer getTotalCircunscripciones() {
        return totalCircunscripciones;
    }

    public void setTotalCircunscripciones(Integer totalCircunscripciones) {
        this.totalCircunscripciones = totalCircunscripciones;
    }

    public Integer getTotalCiudadanos() {
        return totalCiudadanos;
    }

    public void setTotalCiudadanos(Integer totalCiudadanos) {
        this.totalCiudadanos = totalCiudadanos;
    }

    public Integer getTotalEquipos() {
        return totalEquipos;
    }

    public void setTotalEquipos(Integer totalEquipos) {
        this.totalEquipos = totalEquipos;
    }

    public Double getPromedioporEquipo() {
        return promedioporEquipo;
    }

    public void setPromedioporEquipo(Double promedioporEquipo) {
        this.promedioporEquipo = promedioporEquipo;
    }

    public Boolean getRutasOptimizadas() {
        return rutasOptimizadas;
    }

    public void setRutasOptimizadas(Boolean rutasOptimizadas) {
        this.rutasOptimizadas = rutasOptimizadas;
    }
}
