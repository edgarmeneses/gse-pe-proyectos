package pe.gob.pj.solicitudes.data.application.query;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import java.util.List;

/**
 * Query Result para listar solicitudes con metadata de paginación
 * Pertenece a la capa de aplicación, no al dominio
 */
public class SolicitudQueryResult {
    
    private List<Solicitud> solicitudes;
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
    private Boolean first;
    private Boolean last;

    public SolicitudQueryResult() {
    }

    public SolicitudQueryResult(List<Solicitud> solicitudes, Integer page, Integer size, 
                                Long totalElements, Integer totalPages, Boolean first, Boolean last) {
        this.solicitudes = solicitudes;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.first = first;
        this.last = last;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
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
