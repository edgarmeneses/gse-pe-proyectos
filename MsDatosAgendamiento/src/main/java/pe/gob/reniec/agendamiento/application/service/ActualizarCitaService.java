package pe.gob.reniec.agendamiento.application.service;

import pe.gob.reniec.agendamiento.domain.model.Cita;
import pe.gob.reniec.agendamiento.domain.ports.in.ActualizarCitaUseCase;
import pe.gob.reniec.agendamiento.domain.ports.out.CitaRepositoryPort;

public class ActualizarCitaService implements ActualizarCitaUseCase {
    private final CitaRepositoryPort citaRepositoryPort;

    public ActualizarCitaService(CitaRepositoryPort citaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
    }

    @Override
    public Cita actualizar(String citaId, Cita cita) {
        return citaRepositoryPort.actualizar(cita);
    }
}
