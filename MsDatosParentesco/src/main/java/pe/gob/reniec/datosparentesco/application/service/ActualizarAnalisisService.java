package pe.gob.reniec.datosparentesco.application.service;

import pe.gob.reniec.datosparentesco.domain.model.AnalisisParentesco;
import pe.gob.reniec.datosparentesco.domain.ports.in.ActualizarAnalisisUseCase;
import pe.gob.reniec.datosparentesco.domain.ports.out.AnalisisParentescoRepositoryPort;

/**
 * Servicio de aplicación - Implementa el caso de uso de actualizar análisis de parentesco.
 */
public class ActualizarAnalisisService implements ActualizarAnalisisUseCase {
    
    private final AnalisisParentescoRepositoryPort repositoryPort;
    
    public ActualizarAnalisisService(AnalisisParentescoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }
    
    @Override
    public AnalisisParentesco actualizar(String idAnalisis, AnalisisParentesco analisisParentesco) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
