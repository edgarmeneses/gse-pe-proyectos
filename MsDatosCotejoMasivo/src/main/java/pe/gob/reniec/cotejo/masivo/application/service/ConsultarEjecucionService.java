package pe.gob.reniec.cotejo.masivo.application.service;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ConsultarEjecucionUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.EjecucionRepositoryPort;
import java.util.UUID;

public class ConsultarEjecucionService implements ConsultarEjecucionUseCase {
    private final EjecucionRepositoryPort ejecucionRepositoryPort;

    public ConsultarEjecucionService(EjecucionRepositoryPort ejecucionRepositoryPort) {
        this.ejecucionRepositoryPort = ejecucionRepositoryPort;
    }

    @Override
    public Ejecucion consultar(UUID ejecucionId) {
        return ejecucionRepositoryPort.buscarPorId(ejecucionId);
    }
}
