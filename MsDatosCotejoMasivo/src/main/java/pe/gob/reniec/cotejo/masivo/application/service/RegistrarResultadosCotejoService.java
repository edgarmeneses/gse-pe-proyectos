package pe.gob.reniec.cotejo.masivo.application.service;

import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.RegistrarResultadosCotejoUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.ResultadoCotejoRepositoryPort;
import java.util.List;

public class RegistrarResultadosCotejoService implements RegistrarResultadosCotejoUseCase {
    private final ResultadoCotejoRepositoryPort resultadoCotejoRepositoryPort;

    public RegistrarResultadosCotejoService(ResultadoCotejoRepositoryPort resultadoCotejoRepositoryPort) {
        this.resultadoCotejoRepositoryPort = resultadoCotejoRepositoryPort;
    }

    @Override
    public ResultadoRegistroCotejoBatch registrarBatch(String ejecucionId, List<ResultadoCotejo> resultados) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
