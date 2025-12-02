package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.dominio.parentesco.domain.model.AnalisisParentesco;
import pe.gob.reniec.dominio.parentesco.domain.model.Metadata;
import pe.gob.reniec.dominio.parentesco.domain.model.SolicitudAnalisisParentesco;
import pe.gob.reniec.dominio.parentesco.domain.ports.in.EjecutarAnalisisParentescoUseCase;
import pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto.AnalisisParentescoResponseDto;
import pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto.SolicitudAnalisisParentescoRequestDto;
import pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.mapper.ParentescoDtoMapper;

public class ParentescoController {
    private final EjecutarAnalisisParentescoUseCase ejecutarAnalisisUseCase;
    private final ParentescoDtoMapper mapper;

    public ParentescoController(EjecutarAnalisisParentescoUseCase ejecutarAnalisisUseCase,
                               ParentescoDtoMapper mapper) {
        this.ejecutarAnalisisUseCase = ejecutarAnalisisUseCase;
        this.mapper = mapper;
    }

    public AnalisisParentescoResponseDto ejecutarAnalisis(SolicitudAnalisisParentescoRequestDto request) {
        SolicitudAnalisisParentesco solicitud = mapper.toDomain(request);
        AnalisisParentesco resultado = ejecutarAnalisisUseCase.ejecutar(solicitud);
        
        Metadata metadata = new Metadata();
        
        return mapper.toResponseDto(resultado, metadata);
    }
}
