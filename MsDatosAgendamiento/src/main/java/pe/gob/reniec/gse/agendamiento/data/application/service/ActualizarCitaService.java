package pe.gob.reniec.gse.agendamiento.data.application.service;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Cita;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.ActualizarCitaUseCase;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.CitaRepositoryPort;

public class ActualizarCitaService implements ActualizarCitaUseCase {
    
    private final CitaRepositoryPort citaRepositoryPort;
    
    public ActualizarCitaService(CitaRepositoryPort citaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
    }
    
    @Override
    public Cita actualizar(String citaId, Cita cita) {
        cita.setCitaId(citaId);
        return citaRepositoryPort.actualizar(cita);
    }
}
