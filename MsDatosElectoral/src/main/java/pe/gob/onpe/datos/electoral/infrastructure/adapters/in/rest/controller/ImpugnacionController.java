package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.controller;

import pe.gob.onpe.datos.electoral.domain.model.Impugnacion;
import pe.gob.onpe.datos.electoral.domain.ports.in.ConsultarImpugnacionUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.in.ListarImpugnacionesUseCase;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.ImpugnacionResponseDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper.ImpugnacionDtoMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ImpugnacionController {
    private final ConsultarImpugnacionUseCase consultarImpugnacionUseCase;
    private final ListarImpugnacionesUseCase listarImpugnacionesUseCase;

    public ImpugnacionController(ConsultarImpugnacionUseCase consultarImpugnacionUseCase,
                                  ListarImpugnacionesUseCase listarImpugnacionesUseCase) {
        this.consultarImpugnacionUseCase = consultarImpugnacionUseCase;
        this.listarImpugnacionesUseCase = listarImpugnacionesUseCase;
    }

    public ImpugnacionResponseDto consultarPorId(Long id) {
        Impugnacion impugnacion = consultarImpugnacionUseCase.consultarPorId(id);
        return ImpugnacionDtoMapper.toResponseDto(impugnacion);
    }

    public List<ImpugnacionResponseDto> listar() {
        List<Impugnacion> impugnaciones = listarImpugnacionesUseCase.listar();
        return impugnaciones.stream()
                .map(ImpugnacionDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
