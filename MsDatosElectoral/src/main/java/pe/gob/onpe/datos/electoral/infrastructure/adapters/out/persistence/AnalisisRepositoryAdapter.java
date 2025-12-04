package pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence;

import pe.gob.onpe.datos.electoral.domain.model.Analisis;
import pe.gob.onpe.datos.electoral.domain.ports.out.AnalisisRepositoryPort;

public class AnalisisRepositoryAdapter implements AnalisisRepositoryPort {

    @Override
    public Analisis save(Analisis analisis) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    @Override
    public Analisis findById(Long id) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
