package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto;

public record PaginacionDto(
    Integer totalRegistros,
    Integer totalPaginas,
    Integer paginaActual,
    Integer registrosPorPagina,
    Boolean tieneAnterior,
    Boolean tieneSiguiente
) {}
