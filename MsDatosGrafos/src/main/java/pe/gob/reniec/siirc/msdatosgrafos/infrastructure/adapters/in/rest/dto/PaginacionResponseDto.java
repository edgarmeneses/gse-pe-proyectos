package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

/**
 * DTO Record para respuesta de paginación
 */
public record PaginacionResponseDto(
    Long paginaActual,
    Long registrosPorPagina,
    Long totalRegistros,
    Long totalPaginas,
    Boolean tieneAnterior,
    Boolean tieneSiguiente
) {}
