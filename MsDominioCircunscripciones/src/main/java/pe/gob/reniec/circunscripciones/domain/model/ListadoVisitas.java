package pe.gob.reniec.circunscripciones.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class ListadoVisitas {

    private String listadoId;
    private String cronogramaId;
    private LocalDateTime fechaGeneracion;
    private String tipoListado;
    private EstadisticasListado estadisticas;
    private List<EquipoGenerado> equiposGenerados;
    private List<DocumentoGenerado> documentosGenerados;
    private List<ActaVirtual> actasVirtualesGeneradas;

    public ListadoVisitas() {
    }

    public ListadoVisitas(String listadoId, String cronogramaId, LocalDateTime fechaGeneracion,
                         String tipoListado, EstadisticasListado estadisticas,
                         List<EquipoGenerado> equiposGenerados, List<DocumentoGenerado> documentosGenerados,
                         List<ActaVirtual> actasVirtualesGeneradas) {
        this.listadoId = listadoId;
        this.cronogramaId = cronogramaId;
        this.fechaGeneracion = fechaGeneracion;
        this.tipoListado = tipoListado;
        this.estadisticas = estadisticas;
        this.equiposGenerados = equiposGenerados;
        this.documentosGenerados = documentosGenerados;
        this.actasVirtualesGeneradas = actasVirtualesGeneradas;
    }

    public String getListadoId() {
        return listadoId;
    }

    public void setListadoId(String listadoId) {
        this.listadoId = listadoId;
    }

    public String getCronogramaId() {
        return cronogramaId;
    }

    public void setCronogramaId(String cronogramaId) {
        this.cronogramaId = cronogramaId;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getTipoListado() {
        return tipoListado;
    }

    public void setTipoListado(String tipoListado) {
        this.tipoListado = tipoListado;
    }

    public EstadisticasListado getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(EstadisticasListado estadisticas) {
        this.estadisticas = estadisticas;
    }

    public List<EquipoGenerado> getEquiposGenerados() {
        return equiposGenerados;
    }

    public void setEquiposGenerados(List<EquipoGenerado> equiposGenerados) {
        this.equiposGenerados = equiposGenerados;
    }

    public List<DocumentoGenerado> getDocumentosGenerados() {
        return documentosGenerados;
    }

    public void setDocumentosGenerados(List<DocumentoGenerado> documentosGenerados) {
        this.documentosGenerados = documentosGenerados;
    }

    public List<ActaVirtual> getActasVirtualesGeneradas() {
        return actasVirtualesGeneradas;
    }

    public void setActasVirtualesGeneradas(List<ActaVirtual> actasVirtualesGeneradas) {
        this.actasVirtualesGeneradas = actasVirtualesGeneradas;
    }
}
