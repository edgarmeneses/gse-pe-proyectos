package pe.gob.reniec.certificadosdigitales.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.certificadosdigitales.domain.model.CertificadoDigital;
import pe.gob.reniec.certificadosdigitales.domain.model.Ciudadano;
import pe.gob.reniec.certificadosdigitales.domain.model.ConfiguracionCertificados;
import pe.gob.reniec.certificadosdigitales.domain.model.Metadatos;
import pe.gob.reniec.certificadosdigitales.domain.model.Solicitud;
import pe.gob.reniec.certificadosdigitales.domain.ports.in.ObtenerCertificadoDigitalUseCase;
import pe.gob.reniec.certificadosdigitales.infrastructure.adapters.in.rest.dto.ObtenerCertificadoDigitalRequestDto;
import pe.gob.reniec.certificadosdigitales.infrastructure.adapters.in.rest.dto.ObtenerCertificadoDigitalResponseDto;
import pe.gob.reniec.certificadosdigitales.infrastructure.adapters.in.rest.mapper.CertificadoDigitalDtoMapper;

public class CertificadoDigitalController {

    private final ObtenerCertificadoDigitalUseCase obtenerCertificadoDigitalUseCase;
    private final CertificadoDigitalDtoMapper mapper;

    public CertificadoDigitalController(
        ObtenerCertificadoDigitalUseCase obtenerCertificadoDigitalUseCase,
        CertificadoDigitalDtoMapper mapper
    ) {
        this.obtenerCertificadoDigitalUseCase = obtenerCertificadoDigitalUseCase;
        this.mapper = mapper;
    }

    public ObtenerCertificadoDigitalResponseDto obtenerCertificadoDigital(
        ObtenerCertificadoDigitalRequestDto request
    ) {
        Solicitud solicitud = mapper.toSolicitudDomain(request.solicitud());
        Ciudadano ciudadano = mapper.toCiudadanoDomain(request.ciudadano());
        ConfiguracionCertificados configuracion = mapper.toConfiguracionCertificadosDomain(request.configuracionCertificados());
        Metadatos metadatos = mapper.toMetadatosDomain(request.metadatos());

        CertificadoDigital certificadoDigital = obtenerCertificadoDigitalUseCase.obtenerCertificadoDigital(
            solicitud,
            ciudadano,
            configuracion,
            metadatos
        );

        return mapper.toResponseDto(certificadoDigital, true, 201L, "Certificados emitidos exitosamente");
    }
}
