package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.CrearDocumentoUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ConsultarDocumentoUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ActualizarDocumentoUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ListarDocumentosUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ConsultarDocumentoPorDniUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.mapper.DocumentoDtoMapper;
import java.util.List;
import java.util.Map;

public class DocumentoController {
    private final CrearDocumentoUseCase crearDocumentoUseCase;
    private final ConsultarDocumentoUseCase consultarDocumentoUseCase;
    private final ActualizarDocumentoUseCase actualizarDocumentoUseCase;
    private final ListarDocumentosUseCase listarDocumentosUseCase;
    private final ConsultarDocumentoPorDniUseCase consultarDocumentoPorDniUseCase;

    public DocumentoController(CrearDocumentoUseCase crearDocumentoUseCase,
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

    public DocumentoResponseDto crear(DocumentoRequestDto request, Map<String, String> headers) {
        Documento documento = crearDocumentoUseCase.crear(
            request.archivoBase64(),
            request.carpetaId(),
            request.metadata()
        );
        return DocumentoDtoMapper.toResponseDto(documento);
    }

    public ConsultarDocumentoResponseDto obtenerPorId(String id, Map<String, String> headers) {
        Documento documento = consultarDocumentoUseCase.consultarPorId(id);
        return DocumentoDtoMapper.toConsultarResponseDto(documento);
    }

    public ActualizarDocumentoResponseDto actualizar(String id, ActualizarDocumentoRequestDto request, 
                                                     Map<String, String> headers) {
        Documento documento = actualizarDocumentoUseCase.actualizar(
            id,
            request.archivoBase64(),
            request.carpetaId(),
            request.metadata(),
            request.estadoDocumento()
        );
        List<String> camposActualizados = List.of();
        return DocumentoDtoMapper.toActualizarResponseDto(documento, camposActualizados);
    }

    public ListarDocumentosResponseDto listar(String queryParam1, String queryParam2, String queryParam3,
                                             Integer page, Integer size, Map<String, String> headers) {
        List<Documento> documentos = listarDocumentosUseCase.listar(
            queryParam1, queryParam2, queryParam3, page, size
        );
        throw new UnsupportedOperationException("Mapeo de lista de documentos no implementado");
    }

    public Object consultarPorDni(String dni, String tipoDocumento, String fechaDesde, String fechaHasta,
                                 String estadoDocumento, Integer page, Integer size, 
                                 Map<String, String> headers) {
        List<Documento> documentos = consultarDocumentoPorDniUseCase.consultarPorDni(
            dni, tipoDocumento, fechaDesde, fechaHasta, estadoDocumento, page, size
        );
        throw new UnsupportedOperationException("Mapeo de consulta por DNI no implementado");
    }
}
