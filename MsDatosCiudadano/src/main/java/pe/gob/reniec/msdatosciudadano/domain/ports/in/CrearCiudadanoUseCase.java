package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;

public interface CrearCiudadanoUseCase {
    String crear(Ciudadano ciudadano);
}
