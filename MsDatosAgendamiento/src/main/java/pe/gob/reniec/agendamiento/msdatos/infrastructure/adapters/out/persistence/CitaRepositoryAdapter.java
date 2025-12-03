package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.out.persistence;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Cita;
import pe.gob.reniec.agendamiento.msdatos.domain.model.FiltroCita;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.CitaRepositoryPort;
import pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.out.persistence.mapper.CitaPersistenceMapper;
import java.util.List;

public class CitaRepositoryAdapter implements CitaRepositoryPort {
    
    private final CitaPersistenceMapper mapper;

    public CitaRepositoryAdapter() {
        this.mapper = new CitaPersistenceMapper();
    }

    @Override
    public Cita guardar(Cita cita) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public Cita actualizar(Cita cita) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public Cita buscarPorId(String citaId) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public List<Cita> buscarConFiltros(FiltroCita filtro) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public Integer contarConFiltros(FiltroCita filtro) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public Boolean existe(String citaId) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public void eliminar(String citaId) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }
}
