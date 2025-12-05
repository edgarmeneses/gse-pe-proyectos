package pe.gob.reniec.circunscripciones.domain.model;

import java.time.LocalDate;

public class EquipoGenerado {

    private String equipoId;
    private String circunscripcion;
    private Integer cantidadCiudadanos;
    private LocalDate fechaInicioSugerida;
    private Integer diasEstimados;
    private Boolean rutaOptimizada;

    public EquipoGenerado() {
    }

    public EquipoGenerado(String equipoId, String circunscripcion, Integer cantidadCiudadanos,
                         LocalDate fechaInicioSugerida, Integer diasEstimados, Boolean rutaOptimizada) {
        this.equipoId = equipoId;
        this.circunscripcion = circunscripcion;
        this.cantidadCiudadanos = cantidadCiudadanos;
        this.fechaInicioSugerida = fechaInicioSugerida;
        this.diasEstimados = diasEstimados;
        this.rutaOptimizada = rutaOptimizada;
    }

    public String getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(String equipoId) {
        this.equipoId = equipoId;
    }

    public String getCircunscripcion() {
        return circunscripcion;
    }

    public void setCircunscripcion(String circunscripcion) {
        this.circunscripcion = circunscripcion;
    }

    public Integer getCantidadCiudadanos() {
        return cantidadCiudadanos;
    }

    public void setCantidadCiudadanos(Integer cantidadCiudadanos) {
        this.cantidadCiudadanos = cantidadCiudadanos;
    }

    public LocalDate getFechaInicioSugerida() {
        return fechaInicioSugerida;
    }

    public void setFechaInicioSugerida(LocalDate fechaInicioSugerida) {
        this.fechaInicioSugerida = fechaInicioSugerida;
    }

    public Integer getDiasEstimados() {
        return diasEstimados;
    }

    public void setDiasEstimados(Integer diasEstimados) {
        this.diasEstimados = diasEstimados;
    }

    public Boolean getRutaOptimizada() {
        return rutaOptimizada;
    }

    public void setRutaOptimizada(Boolean rutaOptimizada) {
        this.rutaOptimizada = rutaOptimizada;
    }
}
