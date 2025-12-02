package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.gse.datosparentesco.domain.ports.in.ListarTiposParentescoUseCase;
import pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto.TiposParentescoResponseDto;
import pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.mapper.TipoParentescoDtoMapper;

public class TipoParentescoController {
    private final ListarTiposParentescoUseCase listarTiposParentescoUseCase;
    private final TipoParentescoDtoMapper tipoParentescoDtoMapper;

    public TipoParentescoController(ListarTiposParentescoUseCase listarTiposParentescoUseCase,
                                    TipoParentescoDtoMapper tipoParentescoDtoMapper) {
        this.listarTiposParentescoUseCase = listarTiposParentescoUseCase;
        this.tipoParentescoDtoMapper = tipoParentescoDtoMapper;
    }

    public TiposParentescoResponseDto listarTipos(String authorization, String correlationId) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
