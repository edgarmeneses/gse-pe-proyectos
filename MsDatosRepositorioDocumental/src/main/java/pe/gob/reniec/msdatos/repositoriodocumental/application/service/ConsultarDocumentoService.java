package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ConsultarDocumentoUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.DocumentoRepositoryPort;

public class ConsultarDocumentoService implements ConsultarDocumentoUseCase {
    private final DocumentoRepositoryPort documentoRepositoryPort;

    public ConsultarDocumentoService(DocumentoRepositoryPort documentoRepositoryPort) {
        this.documentoRepositoryPort = documentoRepositoryPort;
    }

    @Override
    public Documento consultarPorId(String id) {
        return documentoRepositoryPort.buscarPorId(id);
    }
}
