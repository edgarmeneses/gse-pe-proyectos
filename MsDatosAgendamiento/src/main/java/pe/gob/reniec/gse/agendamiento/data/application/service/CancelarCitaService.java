package pe.gob.reniec.gse.agendamiento.data.application.service;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Cita;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.CancelarCitaUseCase;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.CitaRepositoryPort;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.HistorialCitaRepositoryPort;

public class CancelarCitaService implements CancelarCitaUseCase {
    
    private final CitaRepositoryPort citaRepositoryPort;
    private final HistorialCitaRepositoryPort historialCitaRepositoryPort;
    
    public CancelarCitaService(CitaRepositoryPort citaRepositoryPort,
                              HistorialCitaRepositoryPort historialCitaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
        this.historialCitaRepositoryPort = historialCitaRepositoryPort;
    }
    
    @Override
    public void cancelar(String citaId, String motivoCancelacion, String tokenReagendamiento, String observaciones) {
        Cita cita = citaRepositoryPort.buscarPorId(citaId);
        // Lógica de cancelación aquí
        citaRepositoryPort.actualizar(cita);
    }
}
