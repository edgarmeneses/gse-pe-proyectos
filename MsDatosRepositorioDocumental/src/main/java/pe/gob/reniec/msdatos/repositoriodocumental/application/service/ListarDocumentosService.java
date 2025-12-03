package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ListarDocumentosUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.DocumentoRepositoryPort;
import java.util.Map;

/**
 * Servicio de aplicación: Listar Documentos
 * Implementa la lógica de negocio para listar documentos con filtros.
 */
public class ListarDocumentosService implements ListarDocumentosUseCase {

    private final DocumentoRepositoryPort documentoRepositoryPort;

    public ListarDocumentosService(DocumentoRepositoryPort documentoRepositoryPort) {
        this.documentoRepositoryPort = documentoRepositoryPort;
    }

    @Override
    public pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ListarDocumentosResponseDto listar(Map<String, String> filtros, Integer page, Integer size) {
        return documentoRepositoryPort.listar(filtros, page, size);
    }
}
