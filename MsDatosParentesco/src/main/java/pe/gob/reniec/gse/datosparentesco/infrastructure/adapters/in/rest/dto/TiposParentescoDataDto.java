package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record TiposParentescoDataDto(
        List<TipoParentescoDto> tiposParentesco
) {
}
