package pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import java.util.List;
import java.util.Map;

public interface CarpetaRepositoryPort {
    Carpeta guardar(Carpeta carpeta);
    Carpeta buscarPorId(String id);
    Carpeta actualizar(Carpeta carpeta);
    Map<String, Object> consultarContenido(String id, String queryParam1, String queryParam2, 
                                           String queryParam3, Integer page, Integer size);
}
