package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa métricas de evaluación
 */
public record MetricasDto(
    Double calidadImagen,
    Double legibilidadTexto,
    Double integridadEstructura,
    Double confianzaOCR
) {}
