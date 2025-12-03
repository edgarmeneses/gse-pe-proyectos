package pe.gob.reniec.gse.agendamiento.data.application.service;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Cita;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.CrearCitaUseCase;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.CitaRepositoryPort;

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
