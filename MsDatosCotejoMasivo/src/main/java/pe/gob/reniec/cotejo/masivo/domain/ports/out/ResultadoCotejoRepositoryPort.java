package pe.gob.reniec.cotejo.masivo.domain.ports.out;

import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import java.util.List;
import java.util.UUID;

public interface ResultadoCotejoRepositoryPort {
    List<ResultadoCotejo> guardarLote(List<ResultadoCotejo> resultados);
    ResultadoCotejo buscarPorRegistroEntradaId(UUID registroEntradaId);
    List<ResultadoCotejo> buscarPorEjecucionId(UUID ejecucionId);
}
