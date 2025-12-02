package pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.adapter;

import pe.gob.reniec.agendamiento.domain.model.ExcepcionHoraria;
import pe.gob.reniec.agendamiento.domain.ports.out.ExcepcionHorariaRepositoryPort;
import pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.mapper.ExcepcionHorariaPersistenceMapper;

public class ExcepcionHorariaRepositoryAdapter implements ExcepcionHorariaRepositoryPort {
    private final ExcepcionHorariaPersistenceMapper mapper;

    public ExcepcionHorariaRepositoryAdapter(ExcepcionHorariaPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ExcepcionHoraria guardar(ExcepcionHoraria excepcion) {
        throw new UnsupportedOperationException("Repository implementation not provided - technology neutral");
    }

    @Override
    public ExcepcionHoraria consultarPorId(String excepcionId) {
        throw new UnsupportedOperationException("Repository implementation not provided - technology neutral");
    }
}
