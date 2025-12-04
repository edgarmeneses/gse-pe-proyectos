package pe.gob.onpe.datos.electoral.application.service;

import pe.gob.onpe.datos.electoral.domain.model.Impugnacion;
import pe.gob.onpe.datos.electoral.domain.ports.in.ConsultarImpugnacionUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.out.ImpugnacionRepositoryPort;

public class ConsultarImpugnacionService implements ConsultarImpugnacionUseCase {
    private final ImpugnacionRepositoryPort impugnacionRepositoryPort;

    public ConsultarImpugnacionService(ImpugnacionRepositoryPort impugnacionRepositoryPort) {
        this.impugnacionRepositoryPort = impugnacionRepositoryPort;
    }

    @Override
    public Impugnacion consultarPorId(Long id) {
        return impugnacionRepositoryPort.findById(id);
    }
}
