package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.gse.datosparentesco.domain.ports.in.RegistrarRelacionParentescoUseCase;
import pe.gob.reniec.gse.datosparentesco.domain.ports.in.ConsultarRelacionesUseCase;
import pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.mapper.RelacionParentescoDtoMapper;

public class RelacionParentescoController {
    private final RegistrarRelacionParentescoUseCase registrarRelacionParentescoUseCase;
    private final ConsultarRelacionesUseCase consultarRelacionesUseCase;
    private final RelacionParentescoDtoMapper relacionParentescoDtoMapper;

    public RelacionParentescoController(RegistrarRelacionParentescoUseCase registrarRelacionParentescoUseCase,
                                        ConsultarRelacionesUseCase consultarRelacionesUseCase,
                                        RelacionParentescoDtoMapper relacionParentescoDtoMapper) {
        this.registrarRelacionParentescoUseCase = registrarRelacionParentescoUseCase;
        this.consultarRelacionesUseCase = consultarRelacionesUseCase;
        this.relacionParentescoDtoMapper = relacionParentescoDtoMapper;
    }

    public RelacionParentescoResponseDto registrarRelacion(RelacionParentescoRequestDto request,
                                                           String authorization, String contentType,
                                                           String correlationId) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public ConsultarRelacionesResponseDto consultarRelacionesPorCiudadano(String idCiudadano,
                                                                           String tipoParentesco,
                                                                           Integer gradoMaximo,
                                                                           Boolean incluirInactivos,
                                                                           String authorization,
                                                                           String correlationId) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
