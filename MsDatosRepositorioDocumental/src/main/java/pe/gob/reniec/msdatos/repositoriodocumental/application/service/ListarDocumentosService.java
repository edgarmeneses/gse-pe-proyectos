package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ListarDocumentosUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.DocumentoRepositoryPort;
import java.util.List;

public class ListarDocumentosService implements ListarDocumentosUseCase {
    private final DocumentoRepositoryPort documentoRepositoryPort;

    public ListarDocumentosService(DocumentoRepositoryPort documentoRepositoryPort) {
        this.documentoRepositoryPort = documentoRepositoryPort;
    }

    @Override
    public List<Documento> listar(String queryParam1, String queryParam2, String queryParam3, 
                                 Integer page, Integer size) {
        return documentoRepositoryPort.listar(queryParam1, queryParam2, queryParam3, page, size);
    }
}
