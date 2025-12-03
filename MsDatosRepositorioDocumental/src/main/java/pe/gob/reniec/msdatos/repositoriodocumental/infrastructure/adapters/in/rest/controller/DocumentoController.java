package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.*;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.mapper.DocumentoDtoMapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller REST: Documentos
 * Expone los endpoints para la gestión de documentos sin usar anotaciones.
 */
public class DocumentoController {

    private final CrearDocumentoUseCase crearDocumentoUseCase;
    private final ConsultarDocumentoUseCase consultarDocumentoUseCase;
    private final ActualizarDocumentoUseCase actualizarDocumentoUseCase;
    private final ListarDocumentosUseCase listarDocumentosUseCase;
    private final ConsultarDocumentoPorDniUseCase consultarDocumentoPorDniUseCase;

    public DocumentoController(
            CrearDocumentoUseCase crearDocumentoUseCase,
            ConsultarDocumentoUseCase consultarDocumentoUseCase,
            ActualizarDocumentoUseCase actualizarDocumentoUseCase,
            ListarDocumentosUseCase listarDocumentosUseCase,
            ConsultarDocumentoPorDniUseCase consultarDocumentoPorDniUseCase) {
        this.crearDocumentoUseCase = crearDocumentoUseCase;
        this.consultarDocumentoUseCase = consultarDocumentoUseCase;
        this.actualizarDocumentoUseCase = actualizarDocumentoUseCase;
        this.listarDocumentosUseCase = listarDocumentosUseCase;
        this.consultarDocumentoPorDniUseCase = consultarDocumentoPorDniUseCase;
    }

    /**
     * POST /api/v1/documentos/MsDatosRepositorioDocumental/documento
     * Crea un nuevo documento
     */
    public CrearDocumentoResponseDto crear(CrearDocumentoRequestDto request) {
        Documento documento = DocumentoDtoMapper.toDomain(request);
        Documento creado = crearDocumentoUseCase.crear(documento);
        return DocumentoDtoMapper.toCrearResponseDto(creado);
    }

    /**
     * GET /api/v1/documentos/MsDatosRepositorioDocumental/documento/{id}/descargar
     * Obtiene un documento específico por ID
     */
    public ConsultarDocumentoResponseDto obtenerPorId(String id) {
        Documento documento = consultarDocumentoUseCase.consultarPorId(id);
        return DocumentoDtoMapper.toConsultarResponseDto(documento);
    }

    /**
     * PUT /api/v1/documentos/MsDatosRepositorioDocumental/documento/{id}
     * Actualiza un documento existente
     */
    public ActualizarDocumentoResponseDto actualizar(String id, ActualizarDocumentoRequestDto request) {
        Documento documento = DocumentoDtoMapper.toDomain(request);
        Documento actualizado = actualizarDocumentoUseCase.actualizar(id, documento);
        return DocumentoDtoMapper.toActualizarResponseDto(actualizado);
    }

    /**
     * GET /api/v1/documentos/MsDatosRepositorioDocumental/documento
     * Lista documentos con filtros y paginación
     */
    public ListarDocumentosResponseDto listar(String queryParam1, String queryParam2, String queryParam3, 
                                              Integer page, Integer size) {
        Map<String, String> filtros = new HashMap<>();
        if (queryParam1 != null) filtros.put("queryParam1", queryParam1);
        if (queryParam2 != null) filtros.put("queryParam2", queryParam2);
        if (queryParam3 != null) filtros.put("queryParam3", queryParam3);
        
        return listarDocumentosUseCase.listar(filtros, page, size);
    }

    /**
     * GET /api/v1/documentos/MsDatosRepositorioDocumental/documento/{dni}
     * Consulta documentos de un ciudadano por DNI
     */
    public ConsultarDocumentoPorDniResponseDto consultarPorDni(String dni, String tipoDocumento, String fechaDesde, 
                                                                String fechaHasta, String estadoDocumento, 
                                                                Integer page, Integer size) {
        Map<String, String> filtros = new HashMap<>();
        if (tipoDocumento != null) filtros.put("tipoDocumento", tipoDocumento);
        if (fechaDesde != null) filtros.put("fechaDesde", fechaDesde);
        if (fechaHasta != null) filtros.put("fechaHasta", fechaHasta);
        if (estadoDocumento != null) filtros.put("estadoDocumento", estadoDocumento);
        
        return consultarDocumentoPorDniUseCase.consultarPorDni(dni, filtros, page, size);
    }
}
