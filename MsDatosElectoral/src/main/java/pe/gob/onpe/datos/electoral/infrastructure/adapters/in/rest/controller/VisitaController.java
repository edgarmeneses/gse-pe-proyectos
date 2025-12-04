package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.controller;

import pe.gob.onpe.datos.electoral.domain.model.Visita;
import pe.gob.onpe.datos.electoral.domain.ports.in.RegistrarVisitaUseCase;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.VisitaRequestDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.VisitaResponseDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper.VisitaDtoMapper;

public class VisitaController {
    private final RegistrarVisitaUseCase registrarVisitaUseCase;

    public VisitaController(RegistrarVisitaUseCase registrarVisitaUseCase) {
        this.registrarVisitaUseCase = registrarVisitaUseCase;
    }

    public VisitaResponseDto registrar(VisitaRequestDto requestDto) {
        Visita visita = VisitaDtoMapper.toDomain(requestDto);
        Visita visitaRegistrada = registrarVisitaUseCase.registrar(visita);
        return VisitaDtoMapper.toResponseDto(visitaRegistrada);
    }
}
