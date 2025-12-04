package pe.gob.onpe.datos.electoral.application.service;

import pe.gob.onpe.datos.electoral.domain.model.TachaReclamo;
import pe.gob.onpe.datos.electoral.domain.ports.in.ActualizarTachaReclamoUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.out.TachaReclamoRepositoryPort;

public class ActualizarTachaReclamoService implements ActualizarTachaReclamoUseCase {
    private final TachaReclamoRepositoryPort tachaReclamoRepositoryPort;

    public ActualizarTachaReclamoService(TachaReclamoRepositoryPort tachaReclamoRepositoryPort) {
        this.tachaReclamoRepositoryPort = tachaReclamoRepositoryPort;
    }

    @Override
    public TachaReclamo actualizar(Long id, TachaReclamo tachaReclamo) {
        return tachaReclamoRepositoryPort.update(id, tachaReclamo);
    }
}
