package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

public record PaginacionDto(
    Long totalRegistros,
    Long totalPaginas,
    Long paginaActual,
    Long registrosPorPagina,
    Boolean tieneAnterior,
    Boolean tieneSiguiente
) {}
