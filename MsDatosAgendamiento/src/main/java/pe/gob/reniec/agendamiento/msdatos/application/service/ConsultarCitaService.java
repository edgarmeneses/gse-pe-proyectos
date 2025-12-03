package pe.gob.reniec.agendamiento.msdatos.application.service;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Cita;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.ConsultarCitaUseCase;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.CitaRepositoryPort;

public class ConsultarCitaService implements ConsultarCitaUseCase {
    
    private final CitaRepositoryPort citaRepositoryPort;

    public ConsultarCitaService(CitaRepositoryPort citaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
    }

    @Override
    public Cita consultar(String citaId, Boolean incluirHistorial) {
        return citaRepositoryPort.buscarPorId(citaId);
    }
}
