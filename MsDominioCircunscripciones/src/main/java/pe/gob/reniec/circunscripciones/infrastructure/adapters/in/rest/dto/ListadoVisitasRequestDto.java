package pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ListadoVisitasRequestDto {

    private String cronogramaId;
    private List<String> circunscripciones;
    private String tipoListado;
    private Boolean optimizarRutas;
    private Integer equiposDisponibles;
    private Integer ciudadanosPorEquipo;
    private Boolean incluirMapa;
    private String formatoSalida;
    private String prioridad;

    public ListadoVisitasRequestDto() {
    }

    public String getCronogramaId() {
        return cronogramaId;
    }

    public void setCronogramaId(String cronogramaId) {
        this.cronogramaId = cronogramaId;
    }

    public List<String> getCircunscripciones() {
        return circunscripciones;
    }

    public void setCircunscripciones(List<String> circunscripciones) {
        this.circunscripciones = circunscripciones;
    }

    public String getTipoListado() {
        return tipoListado;
    }

    public void setTipoListado(String tipoListado) {
        this.tipoListado = tipoListado;
    }

    public Boolean getOptimizarRutas() {
        return optimizarRutas;
    }

    public void setOptimizarRutas(Boolean optimizarRutas) {
        this.optimizarRutas = optimizarRutas;
    }

    public Integer getEquiposDisponibles() {
        return equiposDisponibles;
    }

    public void setEquiposDisponibles(Integer equiposDisponibles) {
        this.equiposDisponibles = equiposDisponibles;
    }

    public Integer getCiudadanosPorEquipo() {
        return ciudadanosPorEquipo;
    }

    public void setCiudadanosPorEquipo(Integer ciudadanosPorEquipo) {
        this.ciudadanosPorEquipo = ciudadanosPorEquipo;
    }

    public Boolean getIncluirMapa() {
        return incluirMapa;
    }

    public void setIncluirMapa(Boolean incluirMapa) {
        this.incluirMapa = incluirMapa;
    }

    public String getFormatoSalida() {
        return formatoSalida;
    }

    public void setFormatoSalida(String formatoSalida) {
        this.formatoSalida = formatoSalida;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
