package pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.adaptadorbanconacion.domain.ports.in.ValidarPagoBancoNacionUseCase;
import pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto.ValidacionPagoRequestDto;
import pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto.ValidacionPagoResponseDto;
import pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.mapper.ValidacionPagoDtoMapper;

public class ValidacionPagoController {

    private final ValidarPagoBancoNacionUseCase validarPagoBancoNacionUseCase;
    private final ValidacionPagoDtoMapper mapper;

    public ValidacionPagoController(ValidarPagoBancoNacionUseCase validarPagoBancoNacionUseCase,
                                   ValidacionPagoDtoMapper mapper) {
        this.validarPagoBancoNacionUseCase = validarPagoBancoNacionUseCase;
        this.mapper = mapper;
    }

    public ValidacionPagoResponseDto validarPago(ValidacionPagoRequestDto request) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
