package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.EvaluacionDocumento;
import pe.gob.reniec.coreog.validadordocumentos.domain.model.SolicitudCalificacion;
import pe.gob.reniec.coreog.validadordocumentos.domain.model.SolicitudVerificacionFirma;
import pe.gob.reniec.coreog.validadordocumentos.domain.model.VerificacionFirma;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.in.CalificarDocumentoUseCase;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.in.VerificarFirmaRegistradorUseCase;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto.CalificarDocumentoRequestDto;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto.CalificarDocumentoResponseDto;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto.VerificarFirmaRequestDto;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto.VerificarFirmaResponseDto;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.mapper.CalificarDocumentoDtoMapper;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.mapper.VerificarFirmaDtoMapper;

/**
 * Controlador REST para operaciones de validación de documentos
 * Sin anotaciones - implementación POJO
 * 
 * Path base: /api/v1/documentos/MsCoreogValidadorDocumentos
 */
public class ValidadorDocumentosController {
    
    private final CalificarDocumentoUseCase calificarDocumentoUseCase;
    private final VerificarFirmaRegistradorUseCase verificarFirmaRegistradorUseCase;
    private final CalificarDocumentoDtoMapper calificarMapper;
    private final VerificarFirmaDtoMapper verificarFirmaMapper;
    
    public ValidadorDocumentosController(
            CalificarDocumentoUseCase calificarDocumentoUseCase,
            VerificarFirmaRegistradorUseCase verificarFirmaRegistradorUseCase,
            CalificarDocumentoDtoMapper calificarMapper,
            VerificarFirmaDtoMapper verificarFirmaMapper) {
        this.calificarDocumentoUseCase = calificarDocumentoUseCase;
        this.verificarFirmaRegistradorUseCase = verificarFirmaRegistradorUseCase;
        this.calificarMapper = calificarMapper;
        this.verificarFirmaMapper = verificarFirmaMapper;
    }
    
    /**
     * Endpoint: POST /api/v1/documentos/MsCoreogValidadorDocumentos/calificar
     * Califica uno o más documentos digitales con IA
     * 
     * @param request datos de la solicitud de calificación
     * @return respuesta con la evaluación de los documentos
     */
    public CalificarDocumentoResponseDto calificar(CalificarDocumentoRequestDto request) {
        SolicitudCalificacion solicitud = calificarMapper.toDomain(request);
        EvaluacionDocumento evaluacion = calificarDocumentoUseCase.calificar(solicitud);
        return calificarMapper.toResponseDto(evaluacion);
    }
    
    /**
     * Endpoint: POST /api/v1/documentos/MsCoreogValidadorDocumentos/verificar-firma-registrador
     * Verifica la firma digital de un registrador
     * 
     * @param request datos de la solicitud de verificación
     * @return respuesta con el resultado de la verificación
     */
    public VerificarFirmaResponseDto verificarFirmaRegistrador(VerificarFirmaRequestDto request) {
        SolicitudVerificacionFirma solicitud = verificarFirmaMapper.toDomain(request);
        VerificacionFirma verificacion = verificarFirmaRegistradorUseCase.verificar(solicitud);
        return verificarFirmaMapper.toResponseDto(verificacion);
    }
}
