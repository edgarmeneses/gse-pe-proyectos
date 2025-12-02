package pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.adapter;

import pe.gob.reniec.agendamiento.domain.model.Disponibilidad;
import pe.gob.reniec.agendamiento.domain.ports.out.DisponibilidadRepositoryPort;
import pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.mapper.DisponibilidadPersistenceMapper;
import java.util.Map;

public class DisponibilidadRepositoryAdapter implements DisponibilidadRepositoryPort {
    private final DisponibilidadPersistenceMapper mapper;

    public DisponibilidadRepositoryAdapter(DisponibilidadPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Disponibilidad consultar(Map<String, String> parametros) {
        throw new UnsupportedOperationException("Repository implementation not provided - technology neutral");
    }

    @Override
    public Disponibilidad configurar(Disponibilidad disponibilidad) {
        throw new UnsupportedOperationException("Repository implementation not provided - technology neutral");
    }

    @Override
    public Disponibilidad actualizar(Disponibilidad disponibilidad) {
        throw new UnsupportedOperationException("Repository implementation not provided - technology neutral");
    }

    @Override
    public Disponibilidad consultarPorId(String disponibilidadId) {
        throw new UnsupportedOperationException("Repository implementation not provided - technology neutral");
    }
}
