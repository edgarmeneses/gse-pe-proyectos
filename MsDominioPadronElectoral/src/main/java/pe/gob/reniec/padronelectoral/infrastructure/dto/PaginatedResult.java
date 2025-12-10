package pe.gob.reniec.padronelectoral.infrastructure.dto;

import java.util.List;

public class PaginatedResult<T> {
    private Integer number;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
    private Boolean hasNext;
    private List<T> contenido;

    public PaginatedResult() {
    }

    public PaginatedResult(Integer number, Integer size, Long totalElements, 
                          Integer totalPages, Boolean hasNext, List<T> contenido) {
        this.number = number;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.hasNext = hasNext;
        this.contenido = contenido;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<T> getContenido() {
        return contenido;
    }

    public void setContenido(List<T> contenido) {
        this.contenido = contenido;
    }
}
