package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Disponibilidad;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.*;
import pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.mapper.DisponibilidadDtoMapper;

public class DisponibilidadController {
    
    private final ConsultarDisponibilidadUseCase consultarDisponibilidadUseCase;
    private final ConfigurarDisponibilidadUseCase configurarDisponibilidadUseCase;
    private final ActualizarDisponibilidadUseCase actualizarDisponibilidadUseCase;
    private final DisponibilidadDtoMapper mapper;

    public DisponibilidadController(ConsultarDisponibilidadUseCase consultarDisponibilidadUseCase,
                                    ConfigurarDisponibilidadUseCase configurarDisponibilidadUseCase,
                                    ActualizarDisponibilidadUseCase actualizarDisponibilidadUseCase,
                                    DisponibilidadDtoMapper mapper) {
        this.consultarDisponibilidadUseCase = consultarDisponibilidadUseCase;
        this.configurarDisponibilidadUseCase = configurarDisponibilidadUseCase;
        this.actualizarDisponibilidadUseCase = actualizarDisponibilidadUseCase;
        this.mapper = mapper;
    }

    public ConsultarDisponibilidadResponseDto consultar(String codigoSede, 
                                                         String codigoServicio,
                                                         String fechaConsulta) {
        Disponibilidad disponibilidad = consultarDisponibilidadUseCase.consultar(
            codigoSede, codigoServicio, fechaConsulta);
        return mapper.toConsultarResponseDto(disponibilidad);
    }

    public ConfigurarDisponibilidadResponseDto configurar(ConfigurarDisponibilidadRequestDto request) {
        Disponibilidad disponibilidad = mapper.toDomain(request);
        Disponibilidad disponibilidadCreada = configurarDisponibilidadUseCase.configurar(disponibilidad);
        return mapper.toConfigurarResponseDto(disponibilidadCreada);
    }

    public ActualizarDisponibilidadResponseDto actualizar(String disponibilidadId, 
                                                           ActualizarDisponibilidadRequestDto request) {
        Disponibilidad disponibilidad = mapper.toDomainActualizar(request);
        Disponibilidad disponibilidadActualizada = actualizarDisponibilidadUseCase.actualizar(
            disponibilidadId, disponibilidad);
        return mapper.toActualizarResponseDto(disponibilidadActualizada);
    }
}
