package pe.gob.reniec.datosparentesco.application.service;

import pe.gob.reniec.datosparentesco.domain.model.AnalisisParentesco;
import pe.gob.reniec.datosparentesco.domain.ports.in.CrearAnalisisUseCase;
import pe.gob.reniec.datosparentesco.domain.ports.out.AnalisisParentescoRepositoryPort;

/**
 * Servicio de aplicación - Implementa el caso de uso de crear análisis de parentesco.
 */
public class CrearAnalisisService implements CrearAnalisisUseCase {
    
    private final AnalisisParentescoRepositoryPort repositoryPort;
    
    public CrearAnalisisService(AnalisisParentescoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }
    
    @Override
    public AnalisisParentesco crear(AnalisisParentesco analisisParentesco) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
