package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ListarEjecucionesUseCase.FiltrosEjecucion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ListarEjecucionesUseCase.Paginacion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ListarEjecucionesUseCase.ResultadoPaginado;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.EjecucionRepositoryPort;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.mapper.EjecucionPersistenceMapper;

public class EjecucionRepositoryAdapter implements EjecucionRepositoryPort {
    private final EjecucionPersistenceMapper mapper;

    public EjecucionRepositoryAdapter(EjecucionPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Ejecucion crear(Ejecucion ejecucion) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere tecnología de persistencia");
    }

    @Override
    public Ejecucion consultarPorId(String ejecucionId) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere tecnología de persistencia");
    }

    @Override
    public ResultadoPaginado listar(FiltrosEjecucion filtros, Paginacion paginacion) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere tecnología de persistencia");
    }

    @Override
    public void actualizar(Ejecucion ejecucion) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere tecnología de persistencia");
    }
}
