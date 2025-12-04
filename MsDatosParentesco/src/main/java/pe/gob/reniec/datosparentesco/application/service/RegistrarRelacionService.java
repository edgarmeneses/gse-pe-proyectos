package pe.gob.reniec.datosparentesco.application.service;

import pe.gob.reniec.datosparentesco.domain.model.RelacionParentesco;
import pe.gob.reniec.datosparentesco.domain.ports.in.RegistrarRelacionUseCase;
import pe.gob.reniec.datosparentesco.domain.ports.out.RelacionParentescoRepositoryPort;

/**
 * Servicio de aplicación - Implementa el caso de uso de registrar relación de parentesco.
 */
public class RegistrarRelacionService implements RegistrarRelacionUseCase {
    
    private final RelacionParentescoRepositoryPort repositoryPort;
    
    public RegistrarRelacionService(RelacionParentescoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }
    
    @Override
    public RelacionParentesco registrar(RelacionParentesco relacionParentesco) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
