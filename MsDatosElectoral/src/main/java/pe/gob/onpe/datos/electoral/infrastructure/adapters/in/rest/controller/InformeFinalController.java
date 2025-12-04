package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.controller;

import pe.gob.onpe.datos.electoral.domain.model.InformeFinal;
import pe.gob.onpe.datos.electoral.domain.ports.in.GuardarInformeFinalUseCase;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.InformeFinalRequestDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.InformeFinalResponseDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper.InformeFinalDtoMapper;

public class InformeFinalController {
    private final GuardarInformeFinalUseCase guardarInformeFinalUseCase;

    public InformeFinalController(GuardarInformeFinalUseCase guardarInformeFinalUseCase) {
        this.guardarInformeFinalUseCase = guardarInformeFinalUseCase;
    }

    public InformeFinalResponseDto guardar(InformeFinalRequestDto requestDto) {
        InformeFinal informeFinal = InformeFinalDtoMapper.toDomain(requestDto);
        InformeFinal informeGuardado = guardarInformeFinalUseCase.guardar(informeFinal);
        return InformeFinalDtoMapper.toResponseDto(informeGuardado);
    }
}
