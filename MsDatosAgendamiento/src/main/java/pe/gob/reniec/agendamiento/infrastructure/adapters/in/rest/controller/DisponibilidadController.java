package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.agendamiento.domain.ports.in.ConsultarDisponibilidadUseCase;
import pe.gob.reniec.agendamiento.domain.ports.in.ConfigurarDisponibilidadUseCase;
import pe.gob.reniec.agendamiento.domain.ports.in.ActualizarDisponibilidadUseCase;
import pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.mapper.DisponibilidadDtoMapper;
import pe.gob.reniec.agendamiento.domain.model.Disponibilidad;
import java.util.Map;

public class DisponibilidadController {
    private final ConsultarDisponibilidadUseCase consultarDisponibilidadUseCase;
    private final ConfigurarDisponibilidadUseCase configurarDisponibilidadUseCase;
    private final ActualizarDisponibilidadUseCase actualizarDisponibilidadUseCase;
    private final DisponibilidadDtoMapper mapper;

    public DisponibilidadController(
            ConsultarDisponibilidadUseCase consultarDisponibilidadUseCase,
            ConfigurarDisponibilidadUseCase configurarDisponibilidadUseCase,
            ActualizarDisponibilidadUseCase actualizarDisponibilidadUseCase,
            DisponibilidadDtoMapper mapper) {
        this.consultarDisponibilidadUseCase = consultarDisponibilidadUseCase;
        this.configurarDisponibilidadUseCase = configurarDisponibilidadUseCase;
        this.actualizarDisponibilidadUseCase = actualizarDisponibilidadUseCase;
        this.mapper = mapper;
    }

    public DisponibilidadResponseDto consultarDisponibilidad(Map<String, String> parametros) {
        Disponibilidad disponibilidad = consultarDisponibilidadUseCase.consultar(parametros);
        return mapper.domainToResponseDto(disponibilidad);
    }

    public DisponibilidadResponseDto configurarDisponibilidad(ConfigurarDisponibilidadRequestDto request) {
        Disponibilidad disponibilidad = mapper.requestDtoToDomain(request);
        Disponibilidad disponibilidadConfigurada = configurarDisponibilidadUseCase.configurar(disponibilidad);
        return mapper.domainToResponseDto(disponibilidadConfigurada);
    }

    public DisponibilidadResponseDto actualizarDisponibilidad(String disponibilidadId, ActualizarDisponibilidadRequestDto request) {
        Disponibilidad disponibilidad = mapper.updateRequestDtoToDomain(disponibilidadId, request);
        Disponibilidad disponibilidadActualizada = actualizarDisponibilidadUseCase.actualizar(disponibilidad);
        return mapper.domainToResponseDto(disponibilidadActualizada);
    }
}
