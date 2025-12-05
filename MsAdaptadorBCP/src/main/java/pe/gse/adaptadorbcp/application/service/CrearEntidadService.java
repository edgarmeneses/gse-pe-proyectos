package pe.gse.adaptadorbcp.application.service;

import pe.gse.adaptadorbcp.domain.model.EntidadPlaceholder;
import pe.gse.adaptadorbcp.domain.ports.in.CrearEntidadUseCase;
import pe.gse.adaptadorbcp.domain.ports.out.EntidadRepositoryPort;

public class CrearEntidadService implements CrearEntidadUseCase {

    private final EntidadRepositoryPort repository;

    public CrearEntidadService(EntidadRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public EntidadPlaceholder crear(EntidadPlaceholder entidad) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
