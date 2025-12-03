package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import java.util.List;

public interface ListarCiudadanosUseCase {
    List<Ciudadano> listar(Integer page, Integer size, String queryParam1, String queryParam2, String queryParam3, List<String> fields);
}
