package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.CrearDocumentoUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.DocumentoRepositoryPort;

/**
 * Servicio de aplicación: Crear Documento
 * Implementa la lógica de negocio para crear documentos.
 */
public class CrearDocumentoService implements CrearDocumentoUseCase {

    private final DocumentoRepositoryPort documentoRepositoryPort;

    public CrearDocumentoService(DocumentoRepositoryPort documentoRepositoryPort) {
        this.documentoRepositoryPort = documentoRepositoryPort;
    }

    @Override
    public Documento crear(Documento documento) {
        // Aquí iría la lógica de validación de negocio antes de persistir
        return documentoRepositoryPort.guardar(documento);
    }
}
