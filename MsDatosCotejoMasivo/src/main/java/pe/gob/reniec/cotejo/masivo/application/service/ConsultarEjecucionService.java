package pe.gob.reniec.cotejo.masivo.application.service;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ConsultarEjecucionUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.EjecucionRepositoryPort;

public class ConsultarEjecucionService implements ConsultarEjecucionUseCase {
    private final EjecucionRepositoryPort ejecucionRepositoryPort;

    public ConsultarEjecucionService(EjecucionRepositoryPort ejecucionRepositoryPort) {
        this.ejecucionRepositoryPort = ejecucionRepositoryPort;
    }

    @Override
    public Ejecucion consultarPorId(String ejecucionId) {
        return ejecucionRepositoryPort.consultarPorId(ejecucionId);
    }
}
