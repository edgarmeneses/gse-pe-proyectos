package pe.gob.reniec.cotejo.masivo.application.service;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ConsultarEstadoUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.EjecucionDataPort;

public class ConsultarEstadoService implements ConsultarEstadoUseCase {
    private final EjecucionDataPort ejecucionDataPort;

    public ConsultarEstadoService(EjecucionDataPort ejecucionDataPort) {
        this.ejecucionDataPort = ejecucionDataPort;
    }

    public Ejecucion consultarEstado(String ejecucionId) {
        return ejecucionDataPort.consultarEjecucion(ejecucionId);
    }
}
