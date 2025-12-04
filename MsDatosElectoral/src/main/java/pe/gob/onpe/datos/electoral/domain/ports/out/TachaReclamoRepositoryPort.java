package pe.gob.onpe.datos.electoral.domain.ports.out;

import pe.gob.onpe.datos.electoral.domain.model.TachaReclamo;

public interface TachaReclamoRepositoryPort {
    TachaReclamo save(TachaReclamo tachaReclamo);
    TachaReclamo update(Long id, TachaReclamo tachaReclamo);
}
