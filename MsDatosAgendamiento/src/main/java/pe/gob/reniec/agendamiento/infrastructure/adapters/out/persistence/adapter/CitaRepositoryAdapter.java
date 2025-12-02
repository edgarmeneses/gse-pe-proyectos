package pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.adapter;

import pe.gob.reniec.agendamiento.domain.model.Cita;
import pe.gob.reniec.agendamiento.domain.ports.out.CitaRepositoryPort;
import pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.mapper.CitaPersistenceMapper;
import java.util.List;
import java.util.Map;

public class CitaRepositoryAdapter implements CitaRepositoryPort {
    private final CitaPersistenceMapper mapper;

    public CitaRepositoryAdapter(CitaPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Cita guardar(Cita cita) {
        throw new UnsupportedOperationException("Repository implementation not provided - technology neutral");
    }

    @Override
    public Cita actualizar(Cita cita) {
        throw new UnsupportedOperationException("Repository implementation not provided - technology neutral");
    }

    @Override
    public Cita consultarPorId(String citaId) {
        throw new UnsupportedOperationException("Repository implementation not provided - technology neutral");
    }

    @Override
    public List<Cita> listar(Map<String, String> filtros) {
        throw new UnsupportedOperationException("Repository implementation not provided - technology neutral");
    }

    @Override
    public Cita cancelar(String citaId, String motivo) {
        throw new UnsupportedOperationException("Repository implementation not provided - technology neutral");
    }
}
