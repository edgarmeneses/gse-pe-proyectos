package pe.gob.reniec.agendamiento.msdatos.application.service;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Cita;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.ActualizarCitaUseCase;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.CitaRepositoryPort;

public class ActualizarCitaService implements ActualizarCitaUseCase {
    
    private final CitaRepositoryPort citaRepositoryPort;

    public ActualizarCitaService(CitaRepositoryPort citaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
    }

    @Override
    public Cita actualizar(String citaId, Cita citaActualizada) {
        Cita citaExistente = citaRepositoryPort.buscarPorId(citaId);
        if (citaExistente == null) {
            throw new RuntimeException("Cita no encontrada");
        }
        citaActualizada.setCitaId(citaId);
        return citaRepositoryPort.actualizar(citaActualizada);
    }
}
