package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ActualizarDocumentoUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.DocumentoRepositoryPort;

/**
 * Servicio de aplicación: Actualizar Documento
 * Implementa la lógica de negocio para actualizar documentos.
 */
public class ActualizarDocumentoService implements ActualizarDocumentoUseCase {

    private final DocumentoRepositoryPort documentoRepositoryPort;

    public ActualizarDocumentoService(DocumentoRepositoryPort documentoRepositoryPort) {
        this.documentoRepositoryPort = documentoRepositoryPort;
    }

    @Override
    public Documento actualizar(String id, Documento documento) {
        // Aquí iría la lógica de validación y reglas de negocio
        return documentoRepositoryPort.actualizar(id, documento);
    }
}
