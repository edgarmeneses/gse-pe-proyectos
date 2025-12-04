package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.controller;

import pe.gob.onpe.datos.electoral.domain.model.PaqueteElectoral;
import pe.gob.onpe.datos.electoral.domain.ports.in.ActualizarPaqueteElectoralUseCase;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.PaqueteElectoralRequestDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.PaqueteElectoralResponseDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper.PaqueteElectoralDtoMapper;

public class PaqueteElectoralController {
    private final ActualizarPaqueteElectoralUseCase actualizarPaqueteElectoralUseCase;

    public PaqueteElectoralController(ActualizarPaqueteElectoralUseCase actualizarPaqueteElectoralUseCase) {
        this.actualizarPaqueteElectoralUseCase = actualizarPaqueteElectoralUseCase;
    }

    public PaqueteElectoralResponseDto actualizar(Long id, PaqueteElectoralRequestDto requestDto) {
        PaqueteElectoral paqueteElectoral = PaqueteElectoralDtoMapper.toDomain(requestDto);
        PaqueteElectoral paqueteActualizado = actualizarPaqueteElectoralUseCase.actualizar(id, paqueteElectoral);
        return PaqueteElectoralDtoMapper.toResponseDto(paqueteActualizado);
    }
}
