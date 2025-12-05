package pe.gob.reniec.validadordocumentos.application.service;

import pe.gob.reniec.validadordocumentos.domain.model.EvaluacionDocumento;
import pe.gob.reniec.validadordocumentos.domain.ports.in.RegistrarEvaluacionDocumentoUseCase;
import pe.gob.reniec.validadordocumentos.domain.ports.out.EvaluacionDocumentoRepositoryPort;

/**
 * Servicio de aplicación que implementa el caso de uso de registro de evaluaciones.
 * Coordina la lógica de negocio para persistir evaluaciones de documentos.
 */
public class RegistrarEvaluacionDocumentoService implements RegistrarEvaluacionDocumentoUseCase {

    private final EvaluacionDocumentoRepositoryPort evaluacionDocumentoRepositoryPort;

    public RegistrarEvaluacionDocumentoService(EvaluacionDocumentoRepositoryPort evaluacionDocumentoRepositoryPort) {
        this.evaluacionDocumentoRepositoryPort = evaluacionDocumentoRepositoryPort;
    }

    @Override
    public EvaluacionDocumento registrar(EvaluacionDocumento evaluacionDocumento) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
