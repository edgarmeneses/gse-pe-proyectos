package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence;

import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.ResultadoCotejoRepositoryPort;
import java.util.List;
import java.util.UUID;

public class ResultadoCotejoRepositoryAdapter implements ResultadoCotejoRepositoryPort {

    @Override
    public List<ResultadoCotejo> guardarLote(List<ResultadoCotejo> resultados) {
        throw new UnsupportedOperationException("Operación de persistencia no implementada");
    }

    @Override
    public ResultadoCotejo buscarPorRegistroEntradaId(UUID registroEntradaId) {
        throw new UnsupportedOperationException("Operación de persistencia no implementada");
    }

    @Override
    public List<ResultadoCotejo> buscarPorEjecucionId(UUID ejecucionId) {
        throw new UnsupportedOperationException("Operación de persistencia no implementada");
    }
}
