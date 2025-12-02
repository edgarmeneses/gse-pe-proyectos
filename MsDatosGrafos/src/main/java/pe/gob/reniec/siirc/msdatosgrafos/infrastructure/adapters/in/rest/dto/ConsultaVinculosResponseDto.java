package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Record para respuesta de consulta de vínculos
 */
public record ConsultaVinculosResponseDto(
    Boolean success,
    DataResponseDto data,
    MetadataResponseDto metadata
) {}
