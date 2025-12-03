package pe.gob.reniec.msdatosciudadano.domain.ports.out;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import java.util.List;

public interface CiudadanoRepositoryPort {
    String guardar(Ciudadano ciudadano);
    Ciudadano actualizar(String id, Ciudadano ciudadano);
    Ciudadano buscarPorDocumento(String tipoDocumento, String numeroDocumento);
    List<Ciudadano> listar(Integer page, Integer size, String queryParam1, String queryParam2, String queryParam3, List<String> fields);
}
