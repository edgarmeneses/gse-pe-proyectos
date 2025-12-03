package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence;

import pe.gob.pj.solicitudes.data.domain.model.Trazabilidad;
import pe.gob.pj.solicitudes.data.domain.ports.out.TrazabilidadRepositoryPort;
import java.util.List;

public class TrazabilidadRepositoryAdapter implements TrazabilidadRepositoryPort {
    
    @Override
    public Trazabilidad guardar(Trazabilidad trazabilidad) {
        throw new UnsupportedOperationException("Implementación pendiente según tecnología de persistencia");
    }
    
    @Override
    public List<Trazabilidad> listarPorSolicitud(Long solicitudId) {
        throw new UnsupportedOperationException("Implementación pendiente según tecnología de persistencia");
    }
}
