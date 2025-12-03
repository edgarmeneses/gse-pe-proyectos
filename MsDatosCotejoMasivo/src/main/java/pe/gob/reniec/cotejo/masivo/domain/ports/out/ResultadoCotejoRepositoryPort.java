package pe.gob.reniec.cotejo.masivo.domain.ports.out;

import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import java.util.List;

public interface ResultadoCotejoRepositoryPort {
    List<ResultadoCotejo> crearBatch(List<ResultadoCotejo> resultados);
    ResultadoCotejo consultarPorRegistroEntrada(String registroEntradaId);
    List<ResultadoCotejo> listarPorEjecucion(String ejecucionId);
}
