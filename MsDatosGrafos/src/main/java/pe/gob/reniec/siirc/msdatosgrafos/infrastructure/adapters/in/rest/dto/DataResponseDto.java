package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Record para el contenido de datos de la respuesta
 */
public record DataResponseDto(
    CiudadanoResponseDto ciudadanoConsultado,
    List<VinculoParentescoResponseDto> vinculos,
    ResumenResponseDto resumen,
    PaginacionResponseDto paginacion
) {}
