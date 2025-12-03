package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.agendamiento.domain.ports.in.RegistrarExcepcionHorariaUseCase;
import pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto.RegistrarExcepcionHorariaRequestDto;
import pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto.ExcepcionHorariaResponseDto;
import pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.mapper.ExcepcionHorariaDtoMapper;
import pe.gob.reniec.agendamiento.domain.model.ExcepcionHoraria;

public class ExcepcionHorariaController {
    private final RegistrarExcepcionHorariaUseCase registrarExcepcionHorariaUseCase;
    private final ExcepcionHorariaDtoMapper mapper;

    public ExcepcionHorariaController(
            RegistrarExcepcionHorariaUseCase registrarExcepcionHorariaUseCase,
            ExcepcionHorariaDtoMapper mapper) {
        this.registrarExcepcionHorariaUseCase = registrarExcepcionHorariaUseCase;
        this.mapper = mapper;
    }

    public ExcepcionHorariaResponseDto registrarExcepcion(RegistrarExcepcionHorariaRequestDto request) {
        ExcepcionHoraria excepcion = mapper.requestDtoToDomain(request);
        ExcepcionHoraria excepcionRegistrada = registrarExcepcionHorariaUseCase.registrar(excepcion);
        return mapper.domainToResponseDto(excepcionRegistrada);
    }
}
