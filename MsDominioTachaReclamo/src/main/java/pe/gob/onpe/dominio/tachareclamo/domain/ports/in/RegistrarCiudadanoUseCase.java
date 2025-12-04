package pe.gob.onpe.dominio.tachareclamo.domain.ports.in;

import pe.gob.onpe.dominio.tachareclamo.domain.model.Ciudadano;

public interface RegistrarCiudadanoUseCase {
    Ciudadano registrar(Ciudadano ciudadano);
}
