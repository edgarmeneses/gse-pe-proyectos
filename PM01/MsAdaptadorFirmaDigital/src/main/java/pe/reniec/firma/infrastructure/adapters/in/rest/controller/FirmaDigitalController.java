package pe.reniec.firma.infrastructure.adapters.in.rest.controller;

import pe.reniec.firma.domain.model.ProcesoFirma;
import pe.reniec.firma.domain.model.ProcesoLote;
import pe.reniec.firma.domain.model.ProcesoValidacion;
import pe.reniec.firma.domain.model.SolicitudFirma;
import pe.reniec.firma.domain.model.SolicitudLote;
import pe.reniec.firma.domain.model.SolicitudValidacion;
import pe.reniec.firma.domain.ports.in.FirmarDocumentoUseCase;
import pe.reniec.firma.domain.ports.in.FirmarLoteUseCase;
import pe.reniec.firma.domain.ports.in.ValidarFirmaDigitalUseCase;
import pe.reniec.firma.infrastructure.adapters.in.rest.dto.FirmarDocumentoRequestDto;
import pe.reniec.firma.infrastructure.adapters.in.rest.dto.FirmarDocumentoResponseDto;
import pe.reniec.firma.infrastructure.adapters.in.rest.dto.FirmarLoteRequestDto;
import pe.reniec.firma.infrastructure.adapters.in.rest.dto.FirmarLoteResponseDto;
import pe.reniec.firma.infrastructure.adapters.in.rest.dto.ValidarFirmaRequestDto;
import pe.reniec.firma.infrastructure.adapters.in.rest.dto.ValidarFirmaResponseDto;
import pe.reniec.firma.infrastructure.adapters.in.rest.mapper.FirmaDtoMapper;

public class FirmaDigitalController {

    private final FirmarDocumentoUseCase firmarDocumentoUseCase;
    private final FirmarLoteUseCase firmarLoteUseCase;
    private final ValidarFirmaDigitalUseCase validarFirmaDigitalUseCase;
    private final FirmaDtoMapper mapper;

    public FirmaDigitalController(FirmarDocumentoUseCase firmarDocumentoUseCase,
                                  FirmarLoteUseCase firmarLoteUseCase,
                                  ValidarFirmaDigitalUseCase validarFirmaDigitalUseCase,
                                  FirmaDtoMapper mapper) {
        this.firmarDocumentoUseCase = firmarDocumentoUseCase;
        this.firmarLoteUseCase = firmarLoteUseCase;
        this.validarFirmaDigitalUseCase = validarFirmaDigitalUseCase;
        this.mapper = mapper;
    }

    // POST /api/v1/firma/MsAdaptadorFirmaDigital/firmar-documento
    public FirmarDocumentoResponseDto firmarDocumento(FirmarDocumentoRequestDto request) {
        SolicitudFirma solicitud = mapper.toDomain(request);
        ProcesoFirma resultado = firmarDocumentoUseCase.firmar(solicitud);
        return mapper.toDto(resultado);
    }

    // POST /api/v1/firma/MsAdaptadorFirmaDigital/firmar-lote
    public FirmarLoteResponseDto firmarLote(FirmarLoteRequestDto request) {
        SolicitudLote solicitud = mapper.toDomain(request);
        ProcesoLote resultado = firmarLoteUseCase.firmarLote(solicitud);
        return mapper.toDto(resultado);
    }

    // POST /api/v1/firma/MsAdaptadorFirmaDigital/validar
    public ValidarFirmaResponseDto validarFirma(ValidarFirmaRequestDto request) {
        SolicitudValidacion solicitud = mapper.toDomain(request);
        ProcesoValidacion resultado = validarFirmaDigitalUseCase.validar(solicitud);
        return mapper.toDto(resultado);
    }
}
