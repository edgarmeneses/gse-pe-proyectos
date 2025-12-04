package pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence;

import pe.gob.onpe.datos.electoral.domain.model.Visita;
import pe.gob.onpe.datos.electoral.domain.ports.out.VisitaRepositoryPort;

public class VisitaRepositoryAdapter implements VisitaRepositoryPort {

    @Override
    public Visita save(Visita visita) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
