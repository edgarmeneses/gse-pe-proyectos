package pe.gob.reniec.datosparentesco.application.service;

import pe.gob.reniec.datosparentesco.domain.model.AnalisisParentesco;
import pe.gob.reniec.datosparentesco.domain.ports.in.ConsultarAnalisisUseCase;
import pe.gob.reniec.datosparentesco.domain.ports.out.AnalisisParentescoRepositoryPort;

/**
 * Servicio de aplicación - Implementa el caso de uso de consultar análisis de parentesco por ID.
 */
public class ConsultarAnalisisService implements ConsultarAnalisisUseCase {
    
    private final AnalisisParentescoRepositoryPort repositoryPort;
    
    public ConsultarAnalisisService(AnalisisParentescoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }
    
    @Override
    public AnalisisParentesco consultarPorId(String idAnalisis) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
