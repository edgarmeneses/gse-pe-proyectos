package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;

public interface ConsultarCiudadanoPorIdUseCase {
    Ciudadano consultarPorId(String ciudadanoId);
}

