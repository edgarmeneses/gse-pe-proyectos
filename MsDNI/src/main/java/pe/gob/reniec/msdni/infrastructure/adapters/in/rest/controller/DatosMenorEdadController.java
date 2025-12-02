package pe.gob.reniec.msdni.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdni.domain.ports.in.ConsultarDatosMenorEdadUseCase;
import pe.gob.reniec.msdni.infrastructure.adapters.in.rest.dto.DatosMenorEdadResponseDto;
import pe.gob.reniec.msdni.infrastructure.adapters.in.rest.mapper.DatosMenorEdadDtoMapper;

public class DatosMenorEdadController {
    private final ConsultarDatosMenorEdadUseCase consultarDatosMenorEdadUseCase;
    private final DatosMenorEdadDtoMapper mapper;

    public DatosMenorEdadController(ConsultarDatosMenorEdadUseCase consultarDatosMenorEdadUseCase,
                                    DatosMenorEdadDtoMapper mapper) {
        this.consultarDatosMenorEdadUseCase = consultarDatosMenorEdadUseCase;
        this.mapper = mapper;
    }

    public DatosMenorEdadResponseDto consultarDatosMenorEdad(String cui) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
