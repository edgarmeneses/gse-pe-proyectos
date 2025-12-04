package pe.gob.onpe.datos.electoral.application.service;

import pe.gob.onpe.datos.electoral.domain.model.PaqueteElectoral;
import pe.gob.onpe.datos.electoral.domain.ports.in.ActualizarPaqueteElectoralUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.out.PaqueteElectoralRepositoryPort;

public class ActualizarPaqueteElectoralService implements ActualizarPaqueteElectoralUseCase {
    private final PaqueteElectoralRepositoryPort paqueteElectoralRepositoryPort;

    public ActualizarPaqueteElectoralService(PaqueteElectoralRepositoryPort paqueteElectoralRepositoryPort) {
        this.paqueteElectoralRepositoryPort = paqueteElectoralRepositoryPort;
    }

    @Override
    public PaqueteElectoral actualizar(Long id, PaqueteElectoral paqueteElectoral) {
        return paqueteElectoralRepositoryPort.update(id, paqueteElectoral);
    }
}
