package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.controller;

import pe.gob.onpe.datos.electoral.domain.model.TachaReclamo;
import pe.gob.onpe.datos.electoral.domain.ports.in.ActualizarTachaReclamoUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.in.CrearTachaReclamoUseCase;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.TachaReclamoRequestDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.TachaReclamoResponseDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper.TachaReclamoDtoMapper;

public class TachaReclamoController {
    private final CrearTachaReclamoUseCase crearTachaReclamoUseCase;
    private final ActualizarTachaReclamoUseCase actualizarTachaReclamoUseCase;

    public TachaReclamoController(CrearTachaReclamoUseCase crearTachaReclamoUseCase,
                                  ActualizarTachaReclamoUseCase actualizarTachaReclamoUseCase) {
        this.crearTachaReclamoUseCase = crearTachaReclamoUseCase;
        this.actualizarTachaReclamoUseCase = actualizarTachaReclamoUseCase;
    }

    public TachaReclamoResponseDto crear(TachaReclamoRequestDto requestDto) {
        TachaReclamo tachaReclamo = TachaReclamoDtoMapper.toDomain(requestDto);
        TachaReclamo tachaReclamoCreado = crearTachaReclamoUseCase.crear(tachaReclamo);
        return TachaReclamoDtoMapper.toResponseDto(tachaReclamoCreado);
    }

    public TachaReclamoResponseDto actualizar(Long id, TachaReclamoRequestDto requestDto) {
        TachaReclamo tachaReclamo = TachaReclamoDtoMapper.toDomain(requestDto);
        TachaReclamo tachaReclamoActualizado = actualizarTachaReclamoUseCase.actualizar(id, tachaReclamo);
        return TachaReclamoDtoMapper.toResponseDto(tachaReclamoActualizado);
    }
}
