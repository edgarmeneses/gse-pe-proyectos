package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa el resultado de verificación de firma
 */
public record ResultadoVerificacionDto(
    String estadoFirma,
    Boolean esFirmaValida,
    String detalleEstado,
    String fuenteValidacion,
    Boolean requiereRevisionManual
) {}
