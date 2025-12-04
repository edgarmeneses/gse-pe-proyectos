package pe.gob.onpe.datos.electoral.domain.ports.out;

import pe.gob.onpe.datos.electoral.domain.model.PaqueteElectoral;

public interface PaqueteElectoralRepositoryPort {
    PaqueteElectoral update(Long id, PaqueteElectoral paqueteElectoral);
}
