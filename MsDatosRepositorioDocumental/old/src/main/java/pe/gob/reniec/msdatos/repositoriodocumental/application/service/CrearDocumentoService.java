package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.CrearDocumentoUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.DocumentoRepositoryPort;
import java.util.Map;

public class CrearDocumentoService implements CrearDocumentoUseCase {
    private final DocumentoRepositoryPort documentoRepositoryPort;

    public CrearDocumentoService(DocumentoRepositoryPort documentoRepositoryPort) {
        this.documentoRepositoryPort = documentoRepositoryPort;
    }

    @Override
    public Documento crear(String archivoBase64, String carpetaId, Map<String, Object> metadata) {
        Documento documento = new Documento();
        documento.setArchivoBase64(archivoBase64);
        documento.setCarpetaId(carpetaId);
        documento.setMetadata(metadata);
        return documentoRepositoryPort.guardar(documento);
    }
}
