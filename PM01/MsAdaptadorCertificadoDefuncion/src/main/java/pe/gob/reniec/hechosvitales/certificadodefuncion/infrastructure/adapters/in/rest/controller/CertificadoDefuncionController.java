package pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model.CertificadoDefuncion;
import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.ports.in.ConsultarDatosBasicosUseCase;
import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.ports.in.ConsultarDetalleCompletoUseCase;
import pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto.ConsultaCertificadoRequestDto;
import pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto.ConsultaCertificadoResponseDto;
import pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.mapper.CertificadoDefuncionDtoMapper;

import java.util.List;

/**
 * Controlador REST para el microservicio MsAdaptadorCertificadoDefuncion
 * Maneja las peticiones HTTP para consulta de certificados de defunción
 */
public class CertificadoDefuncionController {

    private final ConsultarDatosBasicosUseCase consultarDatosBasicosUseCase;
    private final ConsultarDetalleCompletoUseCase consultarDetalleCompletoUseCase;
    private final CertificadoDefuncionDtoMapper mapper;

    public CertificadoDefuncionController(
            ConsultarDatosBasicosUseCase consultarDatosBasicosUseCase,
            ConsultarDetalleCompletoUseCase consultarDetalleCompletoUseCase,
            CertificadoDefuncionDtoMapper mapper) {
        this.consultarDatosBasicosUseCase = consultarDatosBasicosUseCase;
        this.consultarDetalleCompletoUseCase = consultarDetalleCompletoUseCase;
        this.mapper = mapper;
    }

    /**
     * Endpoint: POST /api/v1/hechosVitales/MsAdaptadorCertificadoDefuncion/datos-basicos
     * Consulta datos básicos de certificados de defunción
     * 
     * @param request Datos de consulta
     * @return Respuesta con certificados encontrados
     */
    public ConsultaCertificadoResponseDto consultarDatosBasicos(ConsultaCertificadoRequestDto request) {
        List<CertificadoDefuncion> certificados = consultarDatosBasicosUseCase.consultarDatosBasicos(
            request.getCoEntidadConsulta(),
            request.getCoTipoDocIdentidad(),
            request.getDeDocIdentidad()
        );

        return mapper.toResponseDto(certificados);
    }

    /**
     * Endpoint: POST /api/v1/hechosVitales/MsAdaptadorCertificadoDefuncion/detalle-completo
     * Consulta el detalle completo de certificados de defunción
     * 
     * @param request Datos de consulta
     * @return Respuesta con certificados con información completa
     */
    public ConsultaCertificadoResponseDto consultarDetalleCompleto(ConsultaCertificadoRequestDto request) {
        List<CertificadoDefuncion> certificados = consultarDetalleCompletoUseCase.consultarDetalleCompleto(
            request.getCoEntidadConsulta(),
            request.getCoTipoDocIdentidad(),
            request.getDeDocIdentidad()
        );

        return mapper.toResponseDto(certificados);
    }
}
