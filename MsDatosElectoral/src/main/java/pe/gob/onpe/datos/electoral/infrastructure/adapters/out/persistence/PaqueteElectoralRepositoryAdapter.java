package pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence;

import pe.gob.onpe.datos.electoral.domain.model.PaqueteElectoral;
import pe.gob.onpe.datos.electoral.domain.ports.out.PaqueteElectoralRepositoryPort;

public class PaqueteElectoralRepositoryAdapter implements PaqueteElectoralRepositoryPort {

    @Override
    public PaqueteElectoral update(PaqueteElectoral paqueteElectoral) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
