package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;

public interface ConsultarCiudadanoUseCase {
    Ciudadano consultar(String tipoDocumento, String numeroDocumento);
}
