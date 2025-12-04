package pe.gob.onpe.datos.electoral.domain.ports.in;

import pe.gob.onpe.datos.electoral.domain.model.Visita;

public interface RegistrarVisitaUseCase {
    Visita registrar(Visita visita);
}
