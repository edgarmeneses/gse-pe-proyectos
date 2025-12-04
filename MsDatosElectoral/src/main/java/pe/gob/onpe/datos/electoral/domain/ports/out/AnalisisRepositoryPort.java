package pe.gob.onpe.datos.electoral.domain.ports.out;

import pe.gob.onpe.datos.electoral.domain.model.Analisis;

public interface AnalisisRepositoryPort {
    Analisis save(Analisis analisis);
    Analisis findById(Long id);
}
