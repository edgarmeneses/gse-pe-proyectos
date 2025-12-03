package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ActualizarDocumentoUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.DocumentoRepositoryPort;
import java.util.Map;

public class ActualizarDocumentoService implements ActualizarDocumentoUseCase {
    private final DocumentoRepositoryPort documentoRepositoryPort;

    public ActualizarDocumentoService(DocumentoRepositoryPort documentoRepositoryPort) {
        this.documentoRepositoryPort = documentoRepositoryPort;
    }

    @Override
    public Documento actualizar(String id, String archivoBase64, String carpetaId, 
                               Map<String, Object> metadata, String estadoDocumento) {
        Documento documento = documentoRepositoryPort.buscarPorId(id);
        if (archivoBase64 != null) {
            documento.setArchivoBase64(archivoBase64);
        }
        if (carpetaId != null) {
            documento.setCarpetaId(carpetaId);
        }
        if (metadata != null) {
            documento.setMetadata(metadata);
        }
        if (estadoDocumento != null) {
            documento.setEstadoDocumento(estadoDocumento);
        }
        return documentoRepositoryPort.actualizar(documento);
    }
}
