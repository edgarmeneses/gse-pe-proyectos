package pe.gob.reniec.agendamiento.application.service;

import pe.gob.reniec.agendamiento.domain.model.Cita;
import pe.gob.reniec.agendamiento.domain.ports.in.CrearCitaUseCase;
import pe.gob.reniec.agendamiento.domain.ports.out.CitaRepositoryPort;

public class CrearCitaService implements CrearCitaUseCase {
    private final CitaRepositoryPort citaRepositoryPort;

    public CrearCitaService(CitaRepositoryPort citaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
    }

    @Override
    public Cita crear(Cita cita) {
        return citaRepositoryPort.guardar(cita);
    }
}
