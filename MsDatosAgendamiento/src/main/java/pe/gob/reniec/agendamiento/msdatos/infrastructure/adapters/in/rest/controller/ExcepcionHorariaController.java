package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.agendamiento.msdatos.domain.model.ExcepcionHoraria;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.RegistrarExcepcionHorariaUseCase;
import pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.mapper.ExcepcionHorariaDtoMapper;

public class ExcepcionHorariaController {
    
    private final RegistrarExcepcionHorariaUseCase registrarExcepcionHorariaUseCase;
    private final ExcepcionHorariaDtoMapper mapper;

    public ExcepcionHorariaController(RegistrarExcepcionHorariaUseCase registrarExcepcionHorariaUseCase,
                                      ExcepcionHorariaDtoMapper mapper) {
        this.registrarExcepcionHorariaUseCase = registrarExcepcionHorariaUseCase;
        this.mapper = mapper;
    }

    public RegistrarExcepcionHorariaResponseDto registrar(RegistrarExcepcionHorariaRequestDto request) {
        ExcepcionHoraria excepcion = mapper.toDomain(request);
        RegistrarExcepcionHorariaUseCase.ResultadoRegistro resultado = 
            registrarExcepcionHorariaUseCase.registrar(excepcion);
        return mapper.toRegistrarResponseDto(resultado);
    }
}
