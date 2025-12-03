package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

import java.util.Objects;

/**
 * DTO: Información de paginación
 */
public class PaginaDto {
    private final Integer number;
    private final Integer size;
    private final Long totalElements;
    private final Integer totalPages;
    private final Boolean hasNext;
    private final Boolean hasPrevious;

    public PaginaDto(Integer number, Integer size, Long totalElements, Integer totalPages, Boolean hasNext, Boolean hasPrevious) {
        this.number = number;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
    }

    public Integer number() { return number; }
    public Integer size() { return size; }
    public Long totalElements() { return totalElements; }
    public Integer totalPages() { return totalPages; }
    public Boolean hasNext() { return hasNext; }
    public Boolean hasPrevious() { return hasPrevious; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaginaDto paginaDto = (PaginaDto) o;
        return Objects.equals(number, paginaDto.number) && Objects.equals(size, paginaDto.size) && Objects.equals(totalElements, paginaDto.totalElements) && Objects.equals(totalPages, paginaDto.totalPages) && Objects.equals(hasNext, paginaDto.hasNext) && Objects.equals(hasPrevious, paginaDto.hasPrevious);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, size, totalElements, totalPages, hasNext, hasPrevious);
    }

    @Override
    public String toString() {
        return "PaginaDto{" +
                "number=" + number +
                ", size=" + size +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", hasNext=" + hasNext +
                ", hasPrevious=" + hasPrevious +
                '}';
    }
}
