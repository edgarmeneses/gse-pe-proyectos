package pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.controller;

import pe.gob.sunat.sol.adaptadorpki.domain.model.Certificado;
import pe.gob.sunat.sol.adaptadorpki.domain.ports.in.ValidarCertificadoUseCase;
import pe.gob.sunat.sol.adaptadorpki.domain.ports.in.ConsultarCertificadoUseCase;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto.ValidarCertificadoRequestDto;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto.ValidarCertificadoResponseDto;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto.ConsultarCertificadoResponseDto;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.mapper.CertificadoDtoMapper;

public class CertificadoController {
    private final ValidarCertificadoUseCase validarCertificadoUseCase;
    private final ConsultarCertificadoUseCase consultarCertificadoUseCase;
    private final CertificadoDtoMapper certificadoDtoMapper;

    public CertificadoController(ValidarCertificadoUseCase validarCertificadoUseCase,
                                 ConsultarCertificadoUseCase consultarCertificadoUseCase,
                                 CertificadoDtoMapper certificadoDtoMapper) {
        this.validarCertificadoUseCase = validarCertificadoUseCase;
        this.consultarCertificadoUseCase = consultarCertificadoUseCase;
        this.certificadoDtoMapper = certificadoDtoMapper;
    }

    public ValidarCertificadoResponseDto validar(ValidarCertificadoRequestDto requestDto) {
        Certificado certificado = certificadoDtoMapper.toDomain(requestDto);
        Certificado certificadoResultado = validarCertificadoUseCase.validarCertificado(certificado);
        return certificadoDtoMapper.toValidarResponseDto(certificadoResultado);
    }

    public ConsultarCertificadoResponseDto obtenerPorId(String numeroCertificado) {
        Certificado certificado = consultarCertificadoUseCase.consultarCertificado(numeroCertificado);
        return certificadoDtoMapper.toConsultarResponseDto(certificado);
    }
}
