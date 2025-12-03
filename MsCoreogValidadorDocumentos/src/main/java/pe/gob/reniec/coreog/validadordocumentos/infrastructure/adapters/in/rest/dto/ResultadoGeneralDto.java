package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa el resultado general de evaluación
 */
public record ResultadoGeneralDto(
    String estado,
    Double scorePromedio,
    String nivelRiesgo,
    Boolean alertaFraude,
    Boolean requiereRevisionManual,
    String observacionesGenerales
) {}
