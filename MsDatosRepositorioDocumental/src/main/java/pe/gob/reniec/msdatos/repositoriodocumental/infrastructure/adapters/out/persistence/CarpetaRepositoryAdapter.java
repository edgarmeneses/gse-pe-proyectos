package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.CarpetaRepositoryPort;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.entity.CarpetaEntity;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.mapper.CarpetaPersistenceMapper;
import java.util.Map;

public class CarpetaRepositoryAdapter implements CarpetaRepositoryPort {

    @Override
    public Carpeta guardar(Carpeta carpeta) {
        throw new UnsupportedOperationException("Operación guardar carpeta no implementada");
    }

    @Override
    public Carpeta buscarPorId(String id) {
        throw new UnsupportedOperationException("Operación buscar carpeta por ID no implementada");
    }

    @Override
    public Carpeta actualizar(Carpeta carpeta) {
        throw new UnsupportedOperationException("Operación actualizar carpeta no implementada");
    }

    @Override
    public Map<String, Object> consultarContenido(String id, String queryParam1, String queryParam2, 
                                                  String queryParam3, Integer page, Integer size) {
        throw new UnsupportedOperationException("Operación consultar contenido de carpeta no implementada");
    }
}
