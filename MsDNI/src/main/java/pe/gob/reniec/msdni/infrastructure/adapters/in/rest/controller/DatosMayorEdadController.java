package pe.gob.reniec.msdni.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdni.domain.ports.in.ConsultarDatosMayorEdadUseCase;
import pe.gob.reniec.msdni.infrastructure.adapters.in.rest.dto.DatosMayorEdadResponseDto;
import pe.gob.reniec.msdni.infrastructure.adapters.in.rest.mapper.DatosMayorEdadDtoMapper;

public class DatosMayorEdadController {
    private final ConsultarDatosMayorEdadUseCase consultarDatosMayorEdadUseCase;
    private final DatosMayorEdadDtoMapper mapper;

    public DatosMayorEdadController(ConsultarDatosMayorEdadUseCase consultarDatosMayorEdadUseCase,
                                    DatosMayorEdadDtoMapper mapper) {
        this.consultarDatosMayorEdadUseCase = consultarDatosMayorEdadUseCase;
        this.mapper = mapper;
    }

    public DatosMayorEdadResponseDto consultarDatosMayorEdad(String cui) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
