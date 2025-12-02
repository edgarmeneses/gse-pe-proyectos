package pe.gob.reniec.gse.datosparentesco.application.service;

import pe.gob.reniec.gse.datosparentesco.domain.model.RelacionParentesco;
import pe.gob.reniec.gse.datosparentesco.domain.ports.in.RegistrarRelacionParentescoUseCase;
import pe.gob.reniec.gse.datosparentesco.domain.ports.out.RelacionParentescoRepositoryPort;

public class RegistrarRelacionParentescoService implements RegistrarRelacionParentescoUseCase {
    private final RelacionParentescoRepositoryPort relacionParentescoRepositoryPort;

    public RegistrarRelacionParentescoService(RelacionParentescoRepositoryPort relacionParentescoRepositoryPort) {
        this.relacionParentescoRepositoryPort = relacionParentescoRepositoryPort;
    }

    @Override
    public RelacionParentesco registrar(RelacionParentesco relacionParentesco) {
        return relacionParentescoRepositoryPort.guardar(relacionParentesco);
    }
}
