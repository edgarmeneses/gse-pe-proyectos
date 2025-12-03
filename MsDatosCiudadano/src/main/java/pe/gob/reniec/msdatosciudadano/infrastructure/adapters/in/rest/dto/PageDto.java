package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

public record PageDto (
    Integer number,
    Integer size,
    Integer totalElements,
    Integer totalPages,
    Boolean hasNext
){
}
