package pe.gob.reniec.agendamiento.application.service;

import pe.gob.reniec.agendamiento.domain.model.Cita;
import pe.gob.reniec.agendamiento.domain.ports.in.CancelarCitaUseCase;
import pe.gob.reniec.agendamiento.domain.ports.out.CitaRepositoryPort;

public class CancelarCitaService implements CancelarCitaUseCase {
    private final CitaRepositoryPort citaRepositoryPort;

    public CancelarCitaService(CitaRepositoryPort citaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
    }

    @Override
    public Cita cancelar(String citaId, String motivoCancelacion, String tokenReagendamiento, String observaciones) {
        return citaRepositoryPort.cancelar(citaId);
    }
}
