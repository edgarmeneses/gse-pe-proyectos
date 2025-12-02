package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record CriteriosBusquedaDto(
        RangoAniosDto rangoAniosPadres,
        RangoAniosDto rangoAniosHijos,
        List<String> variacionesNombre
) {
}
