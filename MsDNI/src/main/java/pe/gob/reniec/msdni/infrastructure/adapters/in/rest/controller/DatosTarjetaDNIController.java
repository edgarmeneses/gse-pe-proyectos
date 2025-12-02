package pe.gob.reniec.msdni.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdni.domain.ports.in.ConsultarDatosTarjetaDNIUseCase;
import pe.gob.reniec.msdni.infrastructure.adapters.in.rest.dto.DatosTarjetaDNIResponseDto;
import pe.gob.reniec.msdni.infrastructure.adapters.in.rest.mapper.DatosTarjetaDNIDtoMapper;

public class DatosTarjetaDNIController {
    private final ConsultarDatosTarjetaDNIUseCase consultarDatosTarjetaDNIUseCase;
    private final DatosTarjetaDNIDtoMapper mapper;

    public DatosTarjetaDNIController(ConsultarDatosTarjetaDNIUseCase consultarDatosTarjetaDNIUseCase,
                                     DatosTarjetaDNIDtoMapper mapper) {
        this.consultarDatosTarjetaDNIUseCase = consultarDatosTarjetaDNIUseCase;
        this.mapper = mapper;
    }

    public DatosTarjetaDNIResponseDto consultarDatosTarjetaDNI(String cui) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
