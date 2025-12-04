package pe.gob.onpe.datos.electoral.application.service;

import pe.gob.onpe.datos.electoral.domain.model.TachaReclamo;
import pe.gob.onpe.datos.electoral.domain.ports.in.CrearTachaReclamoUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.out.TachaReclamoRepositoryPort;

public class CrearTachaReclamoService implements CrearTachaReclamoUseCase {
    private final TachaReclamoRepositoryPort tachaReclamoRepositoryPort;

    public CrearTachaReclamoService(TachaReclamoRepositoryPort tachaReclamoRepositoryPort) {
        this.tachaReclamoRepositoryPort = tachaReclamoRepositoryPort;
    }

    @Override
    public TachaReclamo crear(TachaReclamo tachaReclamo) {
        return tachaReclamoRepositoryPort.save(tachaReclamo);
    }
}
