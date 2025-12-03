package pe.gob.reniec.agendamiento.msdatos.application.service;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Cita;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.CrearCitaUseCase;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.CitaRepositoryPort;

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
