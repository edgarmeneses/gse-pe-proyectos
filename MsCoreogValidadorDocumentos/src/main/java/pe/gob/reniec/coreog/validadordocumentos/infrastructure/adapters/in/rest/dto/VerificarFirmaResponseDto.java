package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record de respuesta para verificar firma del registrador
 */
public record VerificarFirmaResponseDto(
    Boolean success,
    VerificacionDataDto data,
    MetadataDto metadata
) {}
