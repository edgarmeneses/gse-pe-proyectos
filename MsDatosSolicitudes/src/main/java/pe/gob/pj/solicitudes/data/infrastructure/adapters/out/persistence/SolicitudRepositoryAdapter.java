package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import pe.gob.pj.solicitudes.data.domain.ports.out.SolicitudRepositoryPort;
import java.util.List;

public class SolicitudRepositoryAdapter implements SolicitudRepositoryPort {
    
    @Override
    public Solicitud guardar(Solicitud solicitud) {
        throw new UnsupportedOperationException("Implementación pendiente según tecnología de persistencia");
    }
    
    @Override
    public Solicitud buscarPorId(Long id) {
        throw new UnsupportedOperationException("Implementación pendiente según tecnología de persistencia");
    }
    
    @Override
    public List<Solicitud> listar() {
        throw new UnsupportedOperationException("Implementación pendiente según tecnología de persistencia");
    }
    
    @Override
    public Solicitud actualizar(Long id, Solicitud solicitud) {
        throw new UnsupportedOperationException("Implementación pendiente según tecnología de persistencia");
    }
    
    @Override
    public Boolean existePorCriterio(String criterio) {
        throw new UnsupportedOperationException("Implementación pendiente según tecnología de persistencia");
    }
}
