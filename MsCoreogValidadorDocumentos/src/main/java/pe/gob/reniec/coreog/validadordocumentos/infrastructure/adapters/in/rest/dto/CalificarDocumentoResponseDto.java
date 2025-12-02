package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record de respuesta para calificar documentos
 */
public record CalificarDocumentoResponseDto(
    Boolean success,
    EvaluacionDataDto data,
    MetadataDto metadata
) {}
