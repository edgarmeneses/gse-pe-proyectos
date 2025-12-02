package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ConsultarRelacionesDataDto(
        CiudadanoDto ciudadano,
        List<RelacionItemDto> relaciones,
        Integer totalRelaciones
) {
}
