package pe.gob.onpe.datos.electoral.application.service;

import pe.gob.onpe.datos.electoral.domain.model.Impugnacion;
import pe.gob.onpe.datos.electoral.domain.ports.in.ListarImpugnacionesUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.out.ImpugnacionRepositoryPort;
import java.util.List;

public class ListarImpugnacionesService implements ListarImpugnacionesUseCase {
    private final ImpugnacionRepositoryPort impugnacionRepositoryPort;

    public ListarImpugnacionesService(ImpugnacionRepositoryPort impugnacionRepositoryPort) {
        this.impugnacionRepositoryPort = impugnacionRepositoryPort;
    }

    @Override
    public List<Impugnacion> listar() {
        return impugnacionRepositoryPort.findAll();
    }
}
