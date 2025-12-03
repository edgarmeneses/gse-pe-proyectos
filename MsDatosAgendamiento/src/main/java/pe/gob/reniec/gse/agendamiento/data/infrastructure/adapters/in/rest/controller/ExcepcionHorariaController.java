package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.gse.agendamiento.data.domain.model.CitasAfectadas;
import pe.gob.reniec.gse.agendamiento.data.domain.model.ExcepcionHoraria;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.RegistrarExcepcionHorariaUseCase;
import pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto.ApiResponseDto;

public class ExcepcionHorariaController {
    
    private final RegistrarExcepcionHorariaUseCase registrarExcepcionHorariaUseCase;
    
    public ExcepcionHorariaController(RegistrarExcepcionHorariaUseCase registrarExcepcionHorariaUseCase) {
        this.registrarExcepcionHorariaUseCase = registrarExcepcionHorariaUseCase;
    }
    
    public ApiResponseDto<ExcepcionHoraria> registrar(Object request, String correlationId) {
        throw new UnsupportedOperationException("Registrar excepción horaria no implementado");
    }
}
