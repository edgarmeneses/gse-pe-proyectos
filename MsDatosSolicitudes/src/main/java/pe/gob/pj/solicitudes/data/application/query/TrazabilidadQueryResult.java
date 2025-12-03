package pe.gob.pj.solicitudes.data.application.query;

import pe.gob.pj.solicitudes.data.domain.model.Trazabilidad;
import java.util.Map;
import java.util.List;

/**
 * Query Result para trazabilidad con metadata de estadísticas y resumen
 * Pertenece a la capa de aplicación, no al dominio
 */
public class TrazabilidadQueryResult {
    
    private Trazabilidad trazabilidad;
    
    // Resumen de eventos
    private Long totalCambiosEstado;
    private Long totalModificaciones;
    private Long totalAsignaciones;
    private Long totalDiligencias;
    private Long totalValidaciones;
    private Long totalComentarios;
    private Long totalNotificaciones;
    
    // Estadísticas de tiempos
    private String tiempoTotalProceso;
    private Map<String, String> tiempoPorEtapa;
    private Long usuariosInvolucrados;
    private List<String> oficinasProceso;
    
    // Paginación de eventos
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
    private Boolean first;
    private Boolean last;

    public TrazabilidadQueryResult() {
    }

    public TrazabilidadQueryResult(Trazabilidad trazabilidad) {
        this.trazabilidad = trazabilidad;
    }

    public Trazabilidad getTrazabilidad() {
        return trazabilidad;
    }

    public void setTrazabilidad(Trazabilidad trazabilidad) {
        this.trazabilidad = trazabilidad;
    }

    public Long getTotalCambiosEstado() {
        return totalCambiosEstado;
    }

    public void setTotalCambiosEstado(Long totalCambiosEstado) {
        this.totalCambiosEstado = totalCambiosEstado;
    }

    public Long getTotalModificaciones() {
        return totalModificaciones;
    }

    public void setTotalModificaciones(Long totalModificaciones) {
        this.totalModificaciones = totalModificaciones;
    }

    public Long getTotalAsignaciones() {
        return totalAsignaciones;
    }

    public void setTotalAsignaciones(Long totalAsignaciones) {
        this.totalAsignaciones = totalAsignaciones;
    }

    public Long getTotalDiligencias() {
        return totalDiligencias;
    }

    public void setTotalDiligencias(Long totalDiligencias) {
        this.totalDiligencias = totalDiligencias;
    }

    public Long getTotalValidaciones() {
        return totalValidaciones;
    }

    public void setTotalValidaciones(Long totalValidaciones) {
        this.totalValidaciones = totalValidaciones;
    }

    public Long getTotalComentarios() {
        return totalComentarios;
    }

    public void setTotalComentarios(Long totalComentarios) {
        this.totalComentarios = totalComentarios;
    }

    public Long getTotalNotificaciones() {
        return totalNotificaciones;
    }

    public void setTotalNotificaciones(Long totalNotificaciones) {
        this.totalNotificaciones = totalNotificaciones;
    }

    public String getTiempoTotalProceso() {
        return tiempoTotalProceso;
    }

    public void setTiempoTotalProceso(String tiempoTotalProceso) {
        this.tiempoTotalProceso = tiempoTotalProceso;
    }

    public Map<String, String> getTiempoPorEtapa() {
        return tiempoPorEtapa;
    }

    public void setTiempoPorEtapa(Map<String, String> tiempoPorEtapa) {
        this.tiempoPorEtapa = tiempoPorEtapa;
    }

    public Long getUsuariosInvolucrados() {
        return usuariosInvolucrados;
    }

    public void setUsuariosInvolucrados(Long usuariosInvolucrados) {
        this.usuariosInvolucrados = usuariosInvolucrados;
    }

    public List<String> getOficinasProceso() {
        return oficinasProceso;
    }

    public void setOficinasProceso(List<String> oficinasProceso) {
        this.oficinasProceso = oficinasProceso;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }
}
