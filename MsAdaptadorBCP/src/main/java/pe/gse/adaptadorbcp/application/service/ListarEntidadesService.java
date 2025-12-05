package pe.gse.adaptadorbcp.application.service;

import pe.gse.adaptadorbcp.domain.model.EntidadPlaceholder;
import pe.gse.adaptadorbcp.domain.ports.in.ListarEntidadesUseCase;
import pe.gse.adaptadorbcp.domain.ports.out.EntidadRepositoryPort;

import java.util.List;

public class ListarEntidadesService implements ListarEntidadesUseCase {

    private final EntidadRepositoryPort repository;

    public ListarEntidadesService(EntidadRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<EntidadPlaceholder> listar() {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
