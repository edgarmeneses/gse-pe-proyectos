package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import java.util.List;

public interface ActualizarCiudadanoUseCase {
    List<String> actualizar(String id, Ciudadano ciudadano);
}
