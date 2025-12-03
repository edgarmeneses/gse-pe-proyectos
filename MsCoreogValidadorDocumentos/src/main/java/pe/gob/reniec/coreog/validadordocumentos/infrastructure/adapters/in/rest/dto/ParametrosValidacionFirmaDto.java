package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa parámetros de validación de firma
 */
public record ParametrosValidacionFirmaDto(
    Boolean validarContraBDRegistradores,
    Boolean validarPeriodoVigencia,
    Boolean validarCertificadoDigital
) {}
