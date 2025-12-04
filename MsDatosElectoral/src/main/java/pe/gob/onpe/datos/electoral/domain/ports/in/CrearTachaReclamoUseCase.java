package pe.gob.onpe.datos.electoral.domain.ports.in;

import pe.gob.onpe.datos.electoral.domain.model.TachaReclamo;

public interface CrearTachaReclamoUseCase {
    TachaReclamo crear(TachaReclamo tachaReclamo);
}
