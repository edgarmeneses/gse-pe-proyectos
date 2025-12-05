package pe.gse.adaptadorbcp.application.service;

import pe.gse.adaptadorbcp.domain.ports.in.EliminarEntidadUseCase;
import pe.gse.adaptadorbcp.domain.ports.out.EntidadRepositoryPort;

public class EliminarEntidadService implements EliminarEntidadUseCase {

    private final EntidadRepositoryPort repository;

    public EliminarEntidadService(EntidadRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public boolean eliminar(Long id) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
