package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.CiudadanoRepositoryPort;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence.entity.CiudadanoEntity;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence.mapper.CiudadanoPersistenceMapper;
import java.util.List;

public class CiudadanoRepositoryAdapter implements CiudadanoRepositoryPort {

    @Override
    public String guardar(Ciudadano ciudadano) {
        CiudadanoEntity entity = CiudadanoPersistenceMapper.toEntity(ciudadano);
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    @Override
    public Ciudadano actualizar(String id, Ciudadano ciudadano) {
        CiudadanoEntity entity = CiudadanoPersistenceMapper.toEntity(ciudadano);
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    @Override
    public Ciudadano buscarPorDocumento(String tipoDocumento, String numeroDocumento) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    @Override
    public List<Ciudadano> listar(Integer page, Integer size, String queryParam1, String queryParam2, String queryParam3, List<String> fields) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
