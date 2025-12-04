package pe.gob.onpe.dominio.tachareclamo.domain.ports.out;

import pe.gob.onpe.dominio.tachareclamo.domain.model.TachaReclamo;

public interface TachaReclamoDataPort {
    TachaReclamo crear(TachaReclamo tachaReclamo);
    TachaReclamo actualizar(Long id, TachaReclamo tachaReclamo);
    TachaReclamo obtenerPorId(Long id);
}
