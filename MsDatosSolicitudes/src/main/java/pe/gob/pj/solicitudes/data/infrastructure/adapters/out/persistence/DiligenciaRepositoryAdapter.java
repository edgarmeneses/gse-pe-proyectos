package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence;

import pe.gob.pj.solicitudes.data.domain.model.Diligencia;
import pe.gob.pj.solicitudes.data.domain.ports.out.DiligenciaRepositoryPort;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.entity.DiligenciaEntity;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.mapper.DiligenciaPersistenceMapper;
import java.util.List;

public class DiligenciaRepositoryAdapter implements DiligenciaRepositoryPort {
    
    @Override
    public Diligencia guardar(Diligencia diligencia) {
        throw new UnsupportedOperationException("Implementación pendiente según tecnología de persistencia");
    }
    
    @Override
    public List<Diligencia> listarPorSolicitud(Long solicitudId) {
        throw new UnsupportedOperationException("Implementación pendiente según tecnología de persistencia");
    }
}
