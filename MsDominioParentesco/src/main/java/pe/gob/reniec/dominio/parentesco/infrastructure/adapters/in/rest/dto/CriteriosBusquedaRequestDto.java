package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record CriteriosBusquedaRequestDto(
    RangoAniosRequestDto rangoAniosPadres,
    RangoAniosRequestDto rangoAniosHijos,
    List<String> variacionesNombre,
    Boolean incluirFallecidos,
    Boolean incluirActasAnuladas
) {}
