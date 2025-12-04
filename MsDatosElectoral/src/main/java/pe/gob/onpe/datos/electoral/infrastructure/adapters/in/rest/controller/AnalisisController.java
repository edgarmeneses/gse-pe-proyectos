package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.controller;

import pe.gob.onpe.datos.electoral.domain.model.Analisis;
import pe.gob.onpe.datos.electoral.domain.ports.in.ConsultarAnalisisUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.in.RegistrarAnalisisUseCase;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.AnalisisRequestDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.AnalisisResponseDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper.AnalisisDtoMapper;

public class AnalisisController {
    private final RegistrarAnalisisUseCase registrarAnalisisUseCase;
    private final ConsultarAnalisisUseCase consultarAnalisisUseCase;

    public AnalisisController(RegistrarAnalisisUseCase registrarAnalisisUseCase,
                              ConsultarAnalisisUseCase consultarAnalisisUseCase) {
        this.registrarAnalisisUseCase = registrarAnalisisUseCase;
        this.consultarAnalisisUseCase = consultarAnalisisUseCase;
    }

    public AnalisisResponseDto registrar(AnalisisRequestDto requestDto) {
        Analisis analisis = AnalisisDtoMapper.toDomain(requestDto);
        Analisis analisisRegistrado = registrarAnalisisUseCase.registrar(analisis);
        return AnalisisDtoMapper.toResponseDto(analisisRegistrado);
    }

    public AnalisisResponseDto consultarPorId(Long id) {
        Analisis analisis = consultarAnalisisUseCase.consultarPorId(id);
        return AnalisisDtoMapper.toResponseDto(analisis);
    }
}
