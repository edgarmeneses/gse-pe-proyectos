package pe.gob.reniec.gse.agendamiento.data.application.service;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Cita;
import pe.gob.reniec.gse.agendamiento.data.domain.model.HistorialCita;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.ConsultarCitaUseCase;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.CitaRepositoryPort;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.HistorialCitaRepositoryPort;
import java.util.List;

public class ConsultarCitaService implements ConsultarCitaUseCase {
    
    private final CitaRepositoryPort citaRepositoryPort;
    private final HistorialCitaRepositoryPort historialCitaRepositoryPort;
    
    public ConsultarCitaService(CitaRepositoryPort citaRepositoryPort, 
                               HistorialCitaRepositoryPort historialCitaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
        this.historialCitaRepositoryPort = historialCitaRepositoryPort;
    }
    
    @Override
    public Cita consultar(String citaId, Boolean incluirHistorial) {
        return citaRepositoryPort.buscarPorId(citaId);
    }
    
    @Override
    public List<HistorialCita> consultarHistorial(String citaId) {
        return historialCitaRepositoryPort.listarPorCita(citaId);
    }
}
