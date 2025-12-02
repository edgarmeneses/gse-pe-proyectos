package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.gse.datosparentesco.domain.model.RelacionParentesco;
import pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto.*;
import java.util.List;

public class RelacionParentescoDtoMapper {

    public RelacionParentesco toDomain(RelacionParentescoRequestDto dto) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public RelacionParentescoResponseDto toResponseDto(RelacionParentesco relacionParentesco) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public ConsultarRelacionesResponseDto toConsultarRelacionesResponseDto(List<RelacionParentesco> relaciones) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
