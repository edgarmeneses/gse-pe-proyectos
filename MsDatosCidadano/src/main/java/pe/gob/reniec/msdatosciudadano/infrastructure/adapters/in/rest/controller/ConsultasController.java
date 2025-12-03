package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdatosciudadano.domain.model.CambioDomicilio;
import pe.gob.reniec.msdatosciudadano.domain.model.CotejoMasivo;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.*;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.ConsultaMasivaRequestDto;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.mapper.CotejoMasivoDtoMapper;
import java.util.List;

public class ConsultasController {
    private final ConsultarCambiosDomicilioUseCase consultarCambiosDomicilioUseCase;
    private final ConsultaMasivaUseCase consultaMasivaUseCase;

    public ConsultasController(ConsultarCambiosDomicilioUseCase consultarCambiosDomicilioUseCase,
                              ConsultaMasivaUseCase consultaMasivaUseCase) {
        this.consultarCambiosDomicilioUseCase = consultarCambiosDomicilioUseCase;
        this.consultaMasivaUseCase = consultaMasivaUseCase;
    }

    public List<CambioDomicilio> consultarCambiosDomicilio(String fechaDesde, String fechaHasta, 
                                                           String circunscripcionId, String queryParam1, 
                                                           String queryParam2, String queryParam3) {
        return consultarCambiosDomicilioUseCase.consultar(fechaDesde, fechaHasta, circunscripcionId, 
                                                          queryParam1, queryParam2, queryParam3);
    }

    public CotejoMasivo consultaMasiva(ConsultaMasivaRequestDto request) {
        CotejoMasivo cotejo = CotejoMasivoDtoMapper.toDomain(request);
        return consultaMasivaUseCase.procesar(cotejo);
    }
}
