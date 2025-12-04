package pe.gob.onpe.datos.electoral.domain.ports.out;

import pe.gob.onpe.datos.electoral.domain.model.Visita;

public interface VisitaRepositoryPort {
    Visita save(Visita visita);
}
