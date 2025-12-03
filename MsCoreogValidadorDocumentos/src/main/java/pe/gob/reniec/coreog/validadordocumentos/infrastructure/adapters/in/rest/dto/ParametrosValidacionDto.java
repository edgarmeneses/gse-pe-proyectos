package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO record que representa los parámetros de validación
 */
public record ParametrosValidacionDto(
    Double nivelPonderacionMinimo,
    String modeloIA,
    List<TipoObservacionDto> tiposObservacion
) {}
