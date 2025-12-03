package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.*;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.mapper.AlertaDtoMapper;

public class AlertaController {
    private final CrearAlertaUseCase crearAlertaUseCase;
    private final ListarAlertaUseCase listarAlertaUseCase;
    private final ConsultarAlertaUseCase consultarAlertaUseCase;

    public AlertaController(CrearAlertaUseCase crearAlertaUseCase,
                           ListarAlertaUseCase listarAlertaUseCase,
                           ConsultarAlertaUseCase consultarAlertaUseCase) {
        this.crearAlertaUseCase = crearAlertaUseCase;
        this.listarAlertaUseCase = listarAlertaUseCase;
        this.consultarAlertaUseCase = consultarAlertaUseCase;
    }

    public AlertaResponseDto crear(CrearAlertaRequestDto request) {
        Alerta alerta = AlertaDtoMapper.toDomain(request);
        String id = crearAlertaUseCase.crear(alerta);
        return AlertaDtoMapper.toResponseDto(id, alerta);
    }

    public AlertaListResponseDto listar(Integer page, Integer size, String queryParam1,
                               String queryParam2, String queryParam3) {
        return listarAlertaUseCase.listar(page, size, queryParam1, queryParam2, queryParam3);
    }

    public AlertaConsultaResponseDto consultar(String alertaId) {
        return consultarAlertaUseCase.consultar(alertaId);
    }
}
