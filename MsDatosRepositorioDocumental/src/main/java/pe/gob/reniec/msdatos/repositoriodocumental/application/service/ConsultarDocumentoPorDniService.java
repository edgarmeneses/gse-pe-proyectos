package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ConsultarDocumentoPorDniUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.DocumentoRepositoryPort;
import java.util.List;

public class ConsultarDocumentoPorDniService implements ConsultarDocumentoPorDniUseCase {
    private final DocumentoRepositoryPort documentoRepositoryPort;

    public ConsultarDocumentoPorDniService(DocumentoRepositoryPort documentoRepositoryPort) {
        this.documentoRepositoryPort = documentoRepositoryPort;
    }

    @Override
    public List<Documento> consultarPorDni(String dni, String tipoDocumento, String fechaDesde, 
                                          String fechaHasta, String estadoDocumento, 
                                          Integer page, Integer size) {
        return documentoRepositoryPort.buscarPorDni(dni, tipoDocumento, fechaDesde, 
                                                    fechaHasta, estadoDocumento, page, size);
    }
}
