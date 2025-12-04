package pe.gob.onpe.datos.electoral.application.service;

import pe.gob.onpe.datos.electoral.domain.model.Analisis;
import pe.gob.onpe.datos.electoral.domain.ports.in.ConsultarAnalisisUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.out.AnalisisRepositoryPort;

public class ConsultarAnalisisService implements ConsultarAnalisisUseCase {
    private final AnalisisRepositoryPort analisisRepositoryPort;

    public ConsultarAnalisisService(AnalisisRepositoryPort analisisRepositoryPort) {
        this.analisisRepositoryPort = analisisRepositoryPort;
    }

    @Override
    public Analisis consultarPorId(Long id) {
        return analisisRepositoryPort.findById(id);
    }
}
