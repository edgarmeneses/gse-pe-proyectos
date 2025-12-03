package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

/**
 * DTO para paginación de respuestas API
 * Formato estándar de la API REST
 */
public final class PaginacionDto {
    private final Integer page;
    private final Integer size;
    private final Long totalElements;
    private final Integer totalPages;
    private final Boolean first;
    private final Boolean last;

    public PaginacionDto(Integer page, Integer size, Long totalElements, Integer totalPages, Boolean first, Boolean last) {
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.first = first;
        this.last = last;
    }

    public Integer page() { return page; }
    public Integer size() { return size; }
    public Long totalElements() { return totalElements; }
    public Integer totalPages() { return totalPages; }
    public Boolean first() { return first; }
    public Boolean last() { return last; }
}
