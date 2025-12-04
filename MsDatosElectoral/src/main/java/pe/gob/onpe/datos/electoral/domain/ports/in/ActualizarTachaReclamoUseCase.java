package pe.gob.onpe.datos.electoral.domain.ports.in;

import pe.gob.onpe.datos.electoral.domain.model.TachaReclamo;

public interface ActualizarTachaReclamoUseCase {
    TachaReclamo actualizar(Long id, TachaReclamo tachaReclamo);
}
