package pe.gob.onpe.datos.electoral.domain.ports.in;

import pe.gob.onpe.datos.electoral.domain.model.PaqueteElectoral;

public interface ActualizarPaqueteElectoralUseCase {
    PaqueteElectoral actualizar(Long id, PaqueteElectoral paqueteElectoral);
}
