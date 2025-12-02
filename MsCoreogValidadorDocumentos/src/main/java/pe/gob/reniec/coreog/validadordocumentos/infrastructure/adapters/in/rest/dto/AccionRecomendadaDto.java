package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

/**
 * DTO record que representa una acción recomendada
 */
public record AccionRecomendadaDto(
    String tipo,
    String descripcion,
    String prioridad
) {}
