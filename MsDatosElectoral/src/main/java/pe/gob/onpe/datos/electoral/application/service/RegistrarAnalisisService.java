package pe.gob.onpe.datos.electoral.application.service;

import pe.gob.onpe.datos.electoral.domain.model.Analisis;
import pe.gob.onpe.datos.electoral.domain.ports.in.RegistrarAnalisisUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.out.AnalisisRepositoryPort;

public class RegistrarAnalisisService implements RegistrarAnalisisUseCase {
    private final AnalisisRepositoryPort analisisRepositoryPort;

    public RegistrarAnalisisService(AnalisisRepositoryPort analisisRepositoryPort) {
        this.analisisRepositoryPort = analisisRepositoryPort;
    }

    @Override
    public Analisis registrar(Analisis analisis) {
        return analisisRepositoryPort.save(analisis);
    }
}
