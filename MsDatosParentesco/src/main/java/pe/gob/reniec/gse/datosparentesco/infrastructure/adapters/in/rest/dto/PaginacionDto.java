package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record PaginacionDto(
        Integer totalRegistros,
        Integer totalPaginas,
        Integer paginaActual,
        Integer tamanioPagina,
        Boolean tieneAnterior,
        Boolean tieneSiguiente
) {
}
