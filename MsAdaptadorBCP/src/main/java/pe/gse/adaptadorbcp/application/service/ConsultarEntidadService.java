package pe.gse.adaptadorbcp.application.service;

import pe.gse.adaptadorbcp.domain.model.EntidadPlaceholder;
import pe.gse.adaptadorbcp.domain.ports.in.ConsultarEntidadUseCase;
import pe.gse.adaptadorbcp.domain.ports.out.EntidadRepositoryPort;

public class ConsultarEntidadService implements ConsultarEntidadUseCase {

    private final EntidadRepositoryPort repository;

    public ConsultarEntidadService(EntidadRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public EntidadPlaceholder consultarPorId(Long id) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
