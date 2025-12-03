package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;
import pe.gob.reniec.msdatosciudadano.domain.ports.out.AlertaRepositoryPort;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence.entity.AlertaEntity;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence.mapper.AlertaPersistenceMapper;
import java.util.List;

public class AlertaRepositoryAdapter implements AlertaRepositoryPort {

    @Override
    public String guardar(Alerta alerta) {
        AlertaEntity entity = AlertaPersistenceMapper.toEntity(alerta);
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    @Override
    public Alerta buscarPorId(String alertaId) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    @Override
    public List<Alerta> listar(Integer page, Integer size, String queryParam1, String queryParam2, String queryParam3, List<String> fields) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
