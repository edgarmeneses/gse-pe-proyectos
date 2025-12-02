package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.coreografia.cotejo.domain.model.RespuestaIniciarCotejo;
import pe.gob.reniec.coreografia.cotejo.domain.model.SolicitudCotejoMasivo;
import pe.gob.reniec.coreografia.cotejo.domain.ports.in.IniciarCotejoMasivoUseCase;
import pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto.IniciarCotejoMasivoRequestDto;
import pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto.IniciarCotejoMasivoResponseDto;
import pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.mapper.CotejoMasivoRestMapper;

public class CotejoMasivoController {

    private final IniciarCotejoMasivoUseCase iniciarCotejoMasivoUseCase;
    private final CotejoMasivoRestMapper mapper;

    public CotejoMasivoController(IniciarCotejoMasivoUseCase iniciarCotejoMasivoUseCase, 
                                   CotejoMasivoRestMapper mapper) {
        this.iniciarCotejoMasivoUseCase = iniciarCotejoMasivoUseCase;
        this.mapper = mapper;
    }

    public IniciarCotejoMasivoResponseDto iniciarCotejoMasivo(
            IniciarCotejoMasivoRequestDto request,
            String authorizationHeader,
            String correlationId,
            String officeCode,
            String userRole,
            String requestSource,
            String idempotencyKey) {
        
        SolicitudCotejoMasivo solicitudDominio = mapper.toDomain(request);
        RespuestaIniciarCotejo respuestaDominio = iniciarCotejoMasivoUseCase.iniciarCotejoMasivo(solicitudDominio);
        
        return mapper.toResponseDto(respuestaDominio, correlationId, "v1.0");
    }
}
