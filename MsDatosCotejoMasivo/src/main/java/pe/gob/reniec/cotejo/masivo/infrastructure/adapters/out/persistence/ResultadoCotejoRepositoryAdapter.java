package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence;

import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.ResultadoCotejoRepositoryPort;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.mapper.ResultadoCotejoPersistenceMapper;

import java.util.List;

public class ResultadoCotejoRepositoryAdapter implements ResultadoCotejoRepositoryPort {
    private final ResultadoCotejoPersistenceMapper mapper;

    public ResultadoCotejoRepositoryAdapter(ResultadoCotejoPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ResultadoCotejo> crearBatch(List<ResultadoCotejo> resultados) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere tecnología de persistencia");
    }

    @Override
    public ResultadoCotejo consultarPorRegistroEntrada(String registroEntradaId) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere tecnología de persistencia");
    }

    @Override
    public List<ResultadoCotejo> listarPorEjecucion(String ejecucionId) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere tecnología de persistencia");
    }
}
