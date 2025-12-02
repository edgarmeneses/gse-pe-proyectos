package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO record que representa una observación en la respuesta
 */
public record ObservacionDto(
    String codigo,
    String descripcion,
    String severidad,
    List<String> evidencias
) {}
