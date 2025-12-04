package pe.gob.onpe.dominio.tachareclamo.domain.ports.in;

import pe.gob.onpe.dominio.tachareclamo.domain.model.TachaReclamo;

public interface RegistrarTachaReclamoUseCase {
    TachaReclamo registrar(TachaReclamo tachaReclamo);
}
