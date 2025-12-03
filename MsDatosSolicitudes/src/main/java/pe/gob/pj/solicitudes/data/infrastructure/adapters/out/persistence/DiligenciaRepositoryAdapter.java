package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence;

import pe.gob.pj.solicitudes.data.domain.model.Diligencia;
import pe.gob.pj.solicitudes.data.domain.ports.out.DiligenciaRepositoryPort;

public class DiligenciaRepositoryAdapter implements DiligenciaRepositoryPort {

    @Override
    public Diligencia guardar(Diligencia diligencia) {
        // Aquí iría la lógica de persistencia real (sin tecnología específica)
        throw new UnsupportedOperationException("Método no implementado - requiere tecnología de persistencia");
    }

    @Override
    public Diligencia buscarPorId(String diligenciaId) {
        // Aquí iría la lógica de búsqueda real (sin tecnología específica)
        throw new UnsupportedOperationException("Método no implementado - requiere tecnología de persistencia");
    }
}
