package pe.gob.reniec.cotejo.masivo.application.service;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.CrearEjecucionUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.EjecucionRepositoryPort;

public class CrearEjecucionService implements CrearEjecucionUseCase {
    private final EjecucionRepositoryPort ejecucionRepositoryPort;

    public CrearEjecucionService(EjecucionRepositoryPort ejecucionRepositoryPort) {
        this.ejecucionRepositoryPort = ejecucionRepositoryPort;
    }

    @Override
    public Ejecucion crear(Ejecucion ejecucion) {
        return ejecucionRepositoryPort.guardar(ejecucion);
    }
}
