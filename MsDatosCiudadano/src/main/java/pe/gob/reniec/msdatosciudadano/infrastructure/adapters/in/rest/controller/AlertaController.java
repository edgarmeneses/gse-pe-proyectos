package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;
import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.*;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.mapper.AlertaDtoMapper;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.mapper.CiudadanoDtoMapper;

import java.util.List;

public class AlertaController {
    private final CrearAlertaUseCase crearAlertaUseCase;
    private final ListarAlertaUseCase listarAlertaUseCase;
    private final ConsultarAlertaUseCase consultarAlertaUseCase;
    private final ConsultarCiudadanoPorIdUseCase consultarCiudadanoPorIdUseCase;

    public AlertaController(CrearAlertaUseCase crearAlertaUseCase,
                           ListarAlertaUseCase listarAlertaUseCase,
                           ConsultarAlertaUseCase consultarAlertaUseCase,
                           ConsultarCiudadanoPorIdUseCase consultarCiudadanoPorIdUseCase) {
        this.crearAlertaUseCase = crearAlertaUseCase;
        this.listarAlertaUseCase = listarAlertaUseCase;
        this.consultarAlertaUseCase = consultarAlertaUseCase;
        this.consultarCiudadanoPorIdUseCase = consultarCiudadanoPorIdUseCase;
    }

    public AlertaResponseDto crear(CrearAlertaRequestDto request) {
        Alerta alerta = AlertaDtoMapper.toDomain(request);
        String id = crearAlertaUseCase.crear(alerta);
        return AlertaDtoMapper.toResponseDto(id, alerta);
    }

    public AlertaListResponseDto listar(Integer page, Integer size, String queryParam1,
                               String queryParam2, String queryParam3) {
        List<Alerta> alertas = listarAlertaUseCase.listar(page, size, queryParam1, queryParam2, queryParam3);
        return AlertaDtoMapper.toListResponseDto(alertas, page, size, null);
    }

    public AlertaConsultaResponseDto consultar(String alertaId) {
        Alerta alerta = consultarAlertaUseCase.consultar(alertaId);
        if (alerta == null) return null;
        AlertaDto alertaDto = AlertaDtoMapper.toDto(alerta);
        Ciudadano ciudadano = consultarCiudadanoPorIdUseCase.consultarPorId(alerta.getCiudadanoId());
        CiudadanoDto ciudadanoDto = CiudadanoDtoMapper.toDto(ciudadano);
        return new AlertaConsultaResponseDto(alertaDto, ciudadanoDto);
    }
}
