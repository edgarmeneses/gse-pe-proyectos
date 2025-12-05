package pe.gse.adaptadorbcp.application.service;

import pe.gse.adaptadorbcp.domain.model.EntidadPlaceholder;
import pe.gse.adaptadorbcp.domain.ports.in.ActualizarEntidadUseCase;
import pe.gse.adaptadorbcp.domain.ports.out.EntidadRepositoryPort;

public class ActualizarEntidadService implements ActualizarEntidadUseCase {

    private final EntidadRepositoryPort repository;

    public ActualizarEntidadService(EntidadRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public EntidadPlaceholder actualizar(Long id, EntidadPlaceholder entidad) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
