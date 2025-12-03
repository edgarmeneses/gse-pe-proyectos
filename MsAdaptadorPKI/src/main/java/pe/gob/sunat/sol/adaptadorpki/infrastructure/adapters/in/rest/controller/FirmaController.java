package pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.controller;

import pe.gob.sunat.sol.adaptadorpki.domain.model.Firma;
import pe.gob.sunat.sol.adaptadorpki.domain.ports.in.FirmarDocumentoUseCase;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto.FirmarDocumentoRequestDto;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto.FirmarDocumentoResponseDto;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.mapper.FirmaDtoMapper;

public class FirmaController {
    private final FirmarDocumentoUseCase firmarDocumentoUseCase;
    private final FirmaDtoMapper firmaDtoMapper;

    public FirmaController(FirmarDocumentoUseCase firmarDocumentoUseCase, FirmaDtoMapper firmaDtoMapper) {
        this.firmarDocumentoUseCase = firmarDocumentoUseCase;
        this.firmaDtoMapper = firmaDtoMapper;
    }

    public FirmarDocumentoResponseDto firmar(FirmarDocumentoRequestDto requestDto) {
        Firma firma = firmaDtoMapper.toDomain(requestDto);
        Firma firmaResultado = firmarDocumentoUseCase.firmarDocumento(firma);
        return firmaDtoMapper.toResponseDto(firmaResultado);
    }
}
