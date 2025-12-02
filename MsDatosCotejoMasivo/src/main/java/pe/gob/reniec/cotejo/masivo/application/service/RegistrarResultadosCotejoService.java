package pe.gob.reniec.cotejo.masivo.application.service;

import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.RegistrarResultadosCotejoUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.ResultadoCotejoRepositoryPort;
import java.util.List;
import java.util.UUID;

public class RegistrarResultadosCotejoService implements RegistrarResultadosCotejoUseCase {
    private final ResultadoCotejoRepositoryPort resultadoCotejoRepositoryPort;

    public RegistrarResultadosCotejoService(ResultadoCotejoRepositoryPort resultadoCotejoRepositoryPort) {
        this.resultadoCotejoRepositoryPort = resultadoCotejoRepositoryPort;
    }

    @Override
    public List<ResultadoCotejo> registrar(UUID ejecucionId, List<ResultadoCotejo> resultados) {
        return resultadoCotejoRepositoryPort.guardarLote(resultados);
    }
}
