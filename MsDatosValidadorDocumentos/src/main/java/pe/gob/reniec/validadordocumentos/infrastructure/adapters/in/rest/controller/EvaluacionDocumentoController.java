package pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.validadordocumentos.domain.model.EvaluacionDocumento;
import pe.gob.reniec.validadordocumentos.domain.ports.in.RegistrarEvaluacionDocumentoUseCase;
import pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto.EvaluacionDocumentoRequestDto;
import pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.dto.EvaluacionDocumentoResponseDto;
import pe.gob.reniec.validadordocumentos.infrastructure.adapters.in.rest.mapper.EvaluacionDocumentoDtoMapper;

/**
 * Controlador REST para gestionar evaluaciones de documentos.
 * POJO sin anotaciones de frameworks, cumple con neutralidad tecnológica.
 *
 * Path: POST /api/v1/documentos/MsDatosValidadorDocumentos/evaluacion
 */
public class EvaluacionDocumentoController {

    private final RegistrarEvaluacionDocumentoUseCase registrarEvaluacionDocumentoUseCase;
    private final EvaluacionDocumentoDtoMapper mapper;

    public EvaluacionDocumentoController(RegistrarEvaluacionDocumentoUseCase registrarEvaluacionDocumentoUseCase,
                                         EvaluacionDocumentoDtoMapper mapper) {
        this.registrarEvaluacionDocumentoUseCase = registrarEvaluacionDocumentoUseCase;
        this.mapper = mapper;
    }

    /**
     * Registra una evaluación de documento en el sistema.
     *
     * Endpoint: POST /api/v1/documentos/MsDatosValidadorDocumentos/evaluacion
     *
     * Headers esperados:
     * - Authorization: Bearer token JWT
     * - Content-Type: application/json
     * - X-Correlation-Id: UUID
     * - X-Usuario-Id: String
     * - X-Oficina-Id: String
     *
     * @param request DTO con los datos de la evaluación
     * @return DTO con el resultado del registro
     */
    public EvaluacionDocumentoResponseDto registrar(EvaluacionDocumentoRequestDto request) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
