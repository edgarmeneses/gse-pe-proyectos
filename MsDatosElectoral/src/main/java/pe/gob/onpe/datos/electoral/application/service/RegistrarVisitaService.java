package pe.gob.onpe.datos.electoral.application.service;

import pe.gob.onpe.datos.electoral.domain.model.Visita;
import pe.gob.onpe.datos.electoral.domain.ports.in.RegistrarVisitaUseCase;
import pe.gob.onpe.datos.electoral.domain.ports.out.VisitaRepositoryPort;

public class RegistrarVisitaService implements RegistrarVisitaUseCase {
    private final VisitaRepositoryPort visitaRepositoryPort;

    public RegistrarVisitaService(VisitaRepositoryPort visitaRepositoryPort) {
        this.visitaRepositoryPort = visitaRepositoryPort;
    }

    @Override
    public Visita registrar(Visita visita) {
        return visitaRepositoryPort.save(visita);
    }
}
